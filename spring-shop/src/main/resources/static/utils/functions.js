function addProduct(){
    document.getElementById("add-product").classList.remove("hidden");
}

function addBack(){
    document.getElementById("add-product").classList.add("hidden");
    document.getElementById("add-name").value = "";
    document.getElementById("add-price").value = "";
    console.log("A")
}

function updateProduct(){
    document.getElementById("update-product").classList.remove("hidden");
}

function updateBack(){
    document.getElementById("update-product").classList.add("hidden");
}

function deleteProduct(){
    document.getElementById("delete-product").classList.remove("hidden");
}

function deleteBack(){
    document.getElementById("delete-product").classList.add("hidden");
}