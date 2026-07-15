const nameInput = document.getElementById("name");
const courseSelect = document.getElementById("course");
const emailInput = document.getElementById("email");
const addBtn = document.getElementById("addBtn");
const loadBtn = document.getElementById("loadBtn");
const studentList = document.getElementById("studentList");
const countSpan = document.getElementById("count");     
const messageP = document.getElementById("message");     


addBtn.addEventListener("click", addStudent); // 등록 버튼
loadBtn.addEventListener("click", loadStudents); // 조회 버튼

function loadStudents() { // 수강생 불러오기 함수
    fetch(`http://localhost:10000/api/students`)
        .then(response => {
            if (!response.ok) {
                throw new Error("서버 응답 에러");
            }
            return response.json();
        }) // 서버 응답 처리 및 JSON 변환
        .then(res => {
          
            const list = res.data || res; 
            // Controller가 ResponseDTO로 감싸서 보냈기 때문에 res.data를 쓰고, 
            // 만약 그냥 리스트를 바로 보냈다면 res를 사용하도록 유연하게 예외 처리한 부분
            
            studentList.innerHTML = ""; // 기존 테이블 내용 지우기

            countSpan.textContent = `총 ${list.length}명`; // 전체 인원수 표시

            // 한 명도 없으면 안내 문구 출력
            if (list.length === 0) {
                studentList.innerHTML = `
                    <tr>
                        <td colspan="4" class="empty">
                            등록된 수강생이 없습니다.
                        </td>
                    </tr>`;
                return;
            }

            // 학생 수만큼 반복문을 돌며 테이블의 행(<tr>)을 생성해 추가
            list.forEach((student, index) => {
                // 리스트 안에 들어있는 학생 수만큼 중괄호 { } 안의 코드를 실행해라
                const row = document.createElement("tr");
                // HTML의 테이블 줄 바꿈 태그인 <tr> </tr> (Table Row)를 
                // 임시로 가상 공간에 새로 한 줄 만들기
                
                row.innerHTML = `
                    <td>${student.id || index + 1}</td> 
                    <td>${student.name}</td>
                    <td>${student.course}</td>
                    <td>${student.email}</td>
                `;
                // student.id || index + 1
                // student.id : 값 있으면 ID 값을 그대로 사용
                // index + 1 : 없거나 비어있으면 이걸로 사용

                // innerHTML: 새로 만든 빈 <tr> 상자 안에 들어갈 알맹이(HTML 코드)를 작성해서 채움

                // ${student.name}... : 템플릿 리터럴
                // 문장 중간에 실시간 데이터를 넣을 수 있게 함

                studentList.appendChild(row);
                // appendChild: 줄(<tr>...</tr>)을 
                // 화면의 테이블 뼈대(studentList) 자식으로 붙여서 조립을 완성
            });
            
            messageP.textContent = ""; // 에러 메시지 초기화
        })
        .catch(error => {
            console.error("조회 실패:", error);
            messageP.textContent = "수강생 목록을 불러오는 데 실패했습니다.";
        });
}


function addStudent() { // 수강생 등록 함수
    const name = nameInput.value.trim();
    const course = courseSelect.value;
    const email = emailInput.value.trim();

    
    if (!name) {
        messageP.textContent = "이름을 입력하세요";
        nameInput.focus();
        return; // 여기서 함수를 종료하여 서버 전송을 막음
    }
    if (!course) {
        messageP.textContent = "과정명을 선택하세요.";
        courseSelect.focus();
        return;
    }
    if (!email) {
        messageP.textContent = "이메일을 입력하세요.";
        emailInput.focus();
        return;
    }
    if (!email.includes("@")) {
        messageP.textContent = "이메일에 @가 포함되어야 합니다.";
        emailInput.focus();
        return;
    }

    messageP.textContent = "";

    const payload = {
        name,
        course,
        email
    }; // 데이터 전송 패키지 구성.
    // 서버의 StudentDTO 구조와 일치하도록 이름, 과정명, 이메일을 담은 JSON 객체를 준비

    
    fetch(`http://localhost:10000/api/students`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload) 
        // 백엔드 StudentController의 @PostMapping 메서드로 데이터를 전송
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("서버 저장 실패");
        }
        return response.json();
    })
    .then(data => {
       
        alert("수강생 등록 성공!"); 
        
        // 다음 등록을 위해 창 비우기
        nameInput.value = "";
        courseSelect.value = "";
        emailInput.value = "";
        messageP.textContent = "";

        loadStudents();
        // 등록 성공 후 화면을 자동으로 갱신하기 위해 조회 함수를 다시 호출
    })
    .catch(error => {
        console.error("등록 실패:", error);
        messageP.textContent = "수강생 등록 중 오류가 발생했습니다.";
    });
}