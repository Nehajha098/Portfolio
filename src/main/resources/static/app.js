const name = document.querySelector("#exampleInputName");
const email = document.querySelector("#exampleInputEmail1");
const sendbutn = document.querySelector("#btn");

const navbar = document.querySelector(".navbar");
const navbarCollapseEl = document.getElementById("navbarNav");

if (sendbutn) {
    sendbutn.addEventListener("click", sendData);
}

function sendData(event) {

    let isValid = true;

    if(name.value.trim() === "") {
        isValid = false;
        alert("Sender name is required!");
    }

    if(email.value.trim() === "") {
        isValid = false;
        alert("Sender email is required!");
    } else if(!email.value.includes("@") || !email.value.includes(".")) {
        isValid = false;
        alert("Enter a valid email!");
    }

    if(!isValid) {
        event.preventDefault(); // ONLY block when invalid
        return;
    }

    // allow form submission
}