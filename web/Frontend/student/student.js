const nameInput = document.getElementById("name");
const courseSelect = document.getElementById("course");
const emailInput = document.getElementById("email");
const addBtn = document.getElementById("addBtn");
const loadBtn = document.getElementById("loadBtn");
const studentList = document.getElementById("studentList");
const countSpan = document.getElementById("count");     
const messageP = document.getElementById("message");     


addBtn.addEventListener("click", addStudent);
loadBtn.addEventListener("click", loadStudents);

function loadStudents() {
    fetch(`http://localhost:10000/api/students`)
        .then(response => {
            if (!response.ok) {
                throw new Error("서버 응답 에러");
            }
            return response.json();
        })
        .then(res => {
          
            const list = res.data || res; 
            
            studentList.innerHTML = "";

            countSpan.textContent = `총 ${list.length}명`;

            if (list.length === 0) {
                studentList.innerHTML = `
                    <tr>
                        <td colspan="4" class="empty">등록된 수강생이 없습니다.</td>
                    </tr>`;
                return;
            }

            list.forEach((student, index) => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${student.id || index + 1}</td>
                    <td>${student.name}</td>
                    <td>${student.course}</td>
                    <td>${student.email}</td>
                `;
                studentList.appendChild(row);
            });
            
            messageP.textContent = ""; 
        })
        .catch(error => {
            console.error("조회 실패:", error);
            messageP.textContent = "수강생 목록을 불러오는 데 실패했습니다.";
        });
}


function addStudent() {
    const name = nameInput.value.trim();
    const course = courseSelect.value;
    const email = emailInput.value.trim();

    
    if (!name) {
        alert("이름을 입력해야 합니다.");
        nameInput.focus();
        return;
    }
    if (!course) {
        alert("과정명을 선택해야 합니다.");
        courseSelect.focus();
        return;
    }
    if (!email) {
        alert("이메일을 입력해야 합니다.");
        emailInput.focus();
        return;
    }
    if (!email.includes("@")) {
        alert("이메일에 @가 포함되어야 합니다.");
        emailInput.focus();
        return;
    }

    const payload = {
        name: name,
        course: course,
        email: email
    };

    
    fetch(`http://localhost:10000/api/students`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(payload)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("서버 저장 실패");
        }
        return response.json();
    })
    .then(data => {
       
        alert("수강생 등록 성공!"); 
        
      
        nameInput.value = "";
        courseSelect.value = "";
        emailInput.value = "";
        messageP.textContent = "";

        loadStudents();
    })
    .catch(error => {
        console.error("등록 실패:", error);
        messageP.textContent = "수강생 등록 중 오류가 발생했습니다.";
    });
}