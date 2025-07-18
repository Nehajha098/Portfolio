const name = document.querySelector("#exampleInputName");
const email = document.querySelector("#exampleInputEmail1");
const sendbutn = document.querySelector("#btn");

sendbutn.addEventListener("click", sendData);

function sendData(event) {
    event.preventDefault();

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
        throw new Error("Failed to send message!");
    }

    alert("Message sent successfully.");
}