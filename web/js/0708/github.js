let githubId = document.getElementById("githubId");
let searchBtn = document.getElementById("searchBtn");
let message = document.getElementById("message");
let profileBox = document.getElementById("profileBox");

const validateGithubId = () => {
    const value = githubId.value.trim();

    if(value === ""){
        message.textContent = "아이디를 입력해주세요.";
        message.className = "error";
        return false;
    }

    if(value.length < 3 || value.length > 20){
        message.textContent = "아이디는 3자 이상 20자 이하로 입력하세요.";
        message.className = "error";
        return false;
    }

    let regex = /^[A-Za-z0-9-]+$/;

    if(!regex.test(value)){
        message.textContent = "영어, 숫자, 하이픈만 사용 가능하며 처음과 끝에는 하이픈을 사용할 수 없습니다.";
        message.className = "error";
        return false;
    }

    message.textContent = "올바른 아이디 형식입니다.";
    message.className = "success";
    return true;
}

const checkForm = () => {
    const result = validateGithubId();
    searchBtn.disabled = !result;
    return result;
}

const renderProfile = (user) => {
    profileBox.innerHTML = `
        <div class="card">
            
            <div class="avatar-box">
                <img src="${user.avatar_url}" alt="${user.login}의 프로필 이미지" class="avatar">
            </div>
            
            <div class="profile-info">
                <h3>${user.login} ${user.name ? `<span class="real-name">(${user.name})</span>` : ''}</h3>
                <p class="bio">${user.bio ? user.bio : '소개가 없습니다.'}</p>
                
                <div class="stats-container">
                    <div class="stat-item">
                        <span class="stat-label">팔로워</span>
                        <strong class="stat-count">${user.followers}</strong>
                    </div>
                    <div class="stat-item">
                        <span class="stat-label">팔로잉</span>
                        <strong class="stat-count">${user.following}</strong>
                    </div>
                    <div class="stat-item">
                        <span class="stat-label">저장소</span>
                        <strong class="stat-count">${user.public_repos}</strong>
                    </div>
                </div>
                
                <a href="${user.html_url}" target="_blank" class="link-btn">GitHub 프로필 방문</a>
            </div>
        </div>
    `;
}

githubId.addEventListener("input", checkForm);

searchBtn.addEventListener("click", async()=>{
    if(!checkForm()){
        return;
    }

    const id = githubId.value.trim();
    profileBox.innerHTML = "<p class='loading'>조회 중...</p>";

    try {
        const response = await fetch(`https://api.github.com/users/${id}`);

        if (!response.ok) {
            if (response.status === 404) {
                throw new Error("NOT_FOUND");
            } else if (response.status === 403 || response.status === 429) {
                throw new Error("RATE_LIMIT");
            } else {
                throw new Error("SERVER_ERROR");
            }
        }

        const data = await response.json();
        renderProfile(data);

        githubId.value = "";
        message.textContent = "";
        message.className = ""; 
        searchBtn.disabled = true;

    } catch (error) {
        profileBox.innerHTML = ""; 
        message.className = "error";

        if (error.message === "NOT_FOUND") {
            message.textContent = "존재하지 않는 사용자입니다.";
        } else if (error.message === "RATE_LIMIT") {
            message.textContent = "접근 권한이 없습니다.";
        } else {
            message.textContent = "데이터를 불러오는 중 오류가 발생했습니다.";
        }
        
        searchBtn.disabled = true;
    }
});