// 1. API 주소 설정 
const API_URL = "http://localhost:10000/reservations";

// 2. HTML 요소 가져오기
const reservationId = document.querySelector("#reservationId");
const perName = document.querySelector("#petName"); // 반려동물 이름
const ownerName = document.querySelector("#ownerName"); // 보호자 이름
const animalType = document.querySelector("#animalType"); // 동물 종류
const doctorName = document.querySelector("#doctorName"); // 담당 의사
const reservationDate = document.querySelector("#reservationDate"); // 예약 날짜
const status = document.querySelector("#status"); // 상태
const price = document.querySelector("#price"); // 금액

const saveBtn = document.querySelector("#saveBtn"); // 저장(등록/수정) 버튼
const calcelBtn = document.querySelector("#calcelBtn"); // 취소 버튼
const loadBtn = document.querySelector("#loadBtn"); // 목록 새로고침 버튼
const reservationList = document.querySelector("#reservationList"); // 테이블 tbody

// 3. 주요 기능 함수 구현

// [조회] 예약 목록 전체 불러오기 (GET)
const loadReservations = async () => {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("데이터를 불러오는데 실패했습니다.");

        const data = await response.json();
        renderTable(data);
    } catch (error) {
        console.error("오류 발생:", error);
        reservationList.innerHTML = `
            <tr>
                <td colspan="9" class="empty-msg" style="color: red;">
                    목록을 불러오는 중 오류가 발생했습니다.
                </td>
            </tr>
        `;
    }
};

// 가져온 데이터 목록을 테이블 <tr> 구조로 그리기
const renderTable = (list) => {
    if (!list || list.length === 0) {
        reservationList.innerHTML = `
            <tr>
                <td colspan="9" class="empty-msg">등록된 예약 정보가 없습니다.</td>
            </tr>
        `;
        return;
    }

    reservationList.innerHTML = list.map(item => `
        <tr>
            <td>${item.id}</td>
            <td><strong>${item.petName || ''}</strong></td>
            <td>${item.ownerName || ''}</td>
            <td>${item.animalType || ''}</td>
            <td>${item.doctorName || ''}</td>
            <td>${item.reservationDate || ''}</td>
            <td>
                <span class="status-tag status-${item.status}">${item.status || '예약'}</span>
            </td>
            <td>${item.price ? item.price.toLocaleString() + '원' : '0원'}</td>
            <td>
                <button class="table-btn btn-edit" onclick="editReservation(${item.id})">수정</button>
                <button class="table-btn btn-delete" onclick="deleteReservation(${item.id})">삭제</button>
            </td>
        </tr>
    `).join('');
};

// [단건 조회 & 폼 채우기] 수정 버튼 클릭 시 단건 데이터를 조회해 폼에 채움 (GET /reservations/{id})
const editReservation = async (id) => {
    try {
        const response = await fetch(`${API_URL}/${id}`);
        if (!response.ok) throw new Error("예약 정보를 가져올 수 없습니다.");

        const data = await response.json();

        // Input 폼에 해당 데이터 채워넣기
        reservationId.value = data.id;
        perName.value = data.petName || '';
        ownerName.value = data.ownerName || '';
        animalType.value = data.animalType || '';
        doctorName.value = data.doctorName || '';
        reservationDate.value = data.reservationDate || '';
        status.value = data.status || '예약';
        price.value = data.price || '';

        // 버튼 텍스트 변경
        saveBtn.textContent = "수정 완료";

    } catch (error) {
        alert(error.message);
    }
};

// [등록/수정 처리] 저장 버튼 클릭 이벤트 Handler (POST / PUT)
const handleSave = async () => {
    // 필수값 검증
    if (!perName.value.trim() || !ownerName.value.trim()) {
        alert("반려동물 이름과 보호자 이름은 필수 항목입니다.");
        return;
    }

    // 서버로 전송할 JSON 데이터 바인딩
    const reservationData = {
        petName: perName.value.trim(),
        ownerName: ownerName.value.trim(),
        animalType: animalType.value.trim(),
        doctorName: doctorName.value.trim(),
        reservationDate: reservationDate.value,
        status: status.value,
        price: price.value ? Number(price.value) : 0
    };

    const id = reservationId.value;
    const isEdit = Boolean(id); // id가 존재하면 수정(PUT), 없으면 신규등록(POST)

    const url = isEdit ? `${API_URL}/${id}` : API_URL;
    const method = isEdit ? "PUT" : "POST";

    try {
        const response = await fetch(url, {
            method: method,
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reservationData)
        });

        if (!response.ok) throw new Error("저장에 실패했습니다.");

        alert(isEdit ? "예약 정보가 수정되었습니다." : "새로운 예약이 등록되었습니다.");

        resetForm();
        loadReservations(); // 목록 다시 로드
    } catch (error) {
        alert(error.message);
    }
};

// [삭제] 삭제 버튼 클릭 시 처리 (DELETE)
const deleteReservation = async (id) => {
    if (!confirm(`${id}번 예약을 정말 삭제하시겠습니까?`)) return;

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: "DELETE"
        });

        if (!response.ok) throw new Error("삭제 작업에 실패했습니다.");

        alert("예약이 삭제되었습니다.");
        loadReservations();
    } catch (error) {
        alert(error.message);
    }
};

// [폼 초기화] 입력 항목들 비우기
const resetForm = () => {
    reservationId.value = "";
    perName.value = "";
    ownerName.value = "";
    animalType.value = "";
    doctorName.value = "";
    reservationDate.value = "";
    status.value = "예약";
    price.value = "";

    saveBtn.textContent = "저장";
};

// 4. 이벤트 리스너 바인딩 및 초기 실행

// 저장 버튼 클릭
saveBtn.addEventListener("click", handleSave);

// 취소 버튼 클릭
calcelBtn.addEventListener("click", resetForm);

// 목록 새로고침 버튼 클릭
loadBtn.addEventListener("click", loadReservations);

// 페이지 최초 로딩 시 전체 목록 불러오기
document.addEventListener("DOMContentLoaded", () => {
    loadReservations();
});