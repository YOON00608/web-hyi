const searchInput = document.getElementById("searchInput");
const searchBtn = document.getElementById("searchBtn");
const allBtn = document.getElementById("allBtn");
const message = document.getElementById("message");
const count = document.getElementById("count");
const productList = document.getElementById("productList");

const fetchProducts = async (url) => {
    try {
        productList.innerHTML = "<p>불러오는 중...</p>";
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error("API 호출 실패");
        }
        const data = await response.json();
        renderProducts(data.products);
    } catch (error) {
        message.textContent = "데이터를 불러오는 중 오류가 발생했습니다.";
        message.className = "error";
        productList.innerHTML = "";
        count.textContent = "";
    }
};

const renderProducts = (products) => {
    productList.innerHTML = "";

    if (!products || products.length === 0) {
        count.textContent = "";
        message.textContent = "검색 결과가 없습니다.";
        message.className = "error";
        return;
    }

    message.textContent = "";
    message.className = "";
    count.textContent = `검색 결과: ${products.length}개`;

    products.forEach(product => {
        const isLowStock = product.stock < 10;
        const stockText = isLowStock ? `재고 부족` : `재고 정상`;
        const stockClass = isLowStock ? "stock-low" : "stock-normal";

        productList.innerHTML += `
            <div class="product-card">
                <img src="${product.thumbnail}" alt="${product.title}">
                <p><span style="font-weight:Bold; font-size: 15px;">${product.title}</span></p>
                <p class="category"><span style="font-weight:Bold">카테고리:</span> ${product.category}</p>
                <p class="price-info"><span style="font-weight:Bold">가격:</span> ${product.price}</p>
                <p class="discount"><span style="font-weight:Bold">할인율:</span> ${product.discountPercentage}%</p>
                <p class="rating"><span style="font-weight:Bold">평점:</span> ${product.rating}</p>
                <p class="stock"><span style="font-weight:Bold">재고:</span> ${product.stock}</p>
                <p class="${stockClass}">${stockText}</p>
            </div>
        `;
    });
};

const validateSearch = () => {
    const value = searchInput.value.trim();
    const specialCharRegex = /[{}[\]\/?.,;:|)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;

    if (value === "") {
        message.textContent = "검색어를 입력하세요.";
        message.className = "error";
        return false;
    }

    if (value.length < 2) {
        message.textContent = "검색어는 2글자 이상 입력하세요.";
        message.className = "error";
        return false;
    }

    if (specialCharRegex.test(value)) {
        message.textContent = "검색어에는 특수문자를 입력할 수 없습니다.";
        message.className = "error";
        return false;
    }

    return true;
};

window.addEventListener("DOMContentLoaded", () => {
    fetchProducts("https://dummyjson.com/products?limit=30");
});

searchBtn.addEventListener("click", () => {
    if (!validateSearch()) {
        return;
    }
    const query = searchInput.value.trim();
    fetchProducts(`https://dummyjson.com/products/search?q=${query}`);
});

allBtn.addEventListener("click", () => {
    searchInput.value = "";
    message.textContent = "";
    message.className = "";
    fetchProducts("https://dummyjson.com/products?limit=30");
});
