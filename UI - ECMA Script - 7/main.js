let click = 0;

function validateField() {
  let inputFieldValue = document.getElementById("input-field").value;

  const nameRegex = /^[A-Z a-z]+$/;
  const emailRegex = /^[A-Za-z0-9_.]+\@([A-Za-z0-9_])+\.([A-Za-z]{2,4})$/;
  const vehicalNumberRegex = /^[A-Za-z]{2}[0-9]{6}$/;

  let inputField = document.getElementById("input-field");
  let errorMsg = document.getElementById("error-msg");

  if (
    (click == 0 || click == 5 || click == 7) &&
    !nameRegex.test(inputFieldValue)
  ) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML = "Name should contains alphabetes only.";
    return false;
  } else if (click == 0 || click == 5 || click == 7) {
    errorMsg.innerHTML = "";
    inputField.style.borderColor = "#9ecaed";
    console.log("into first if");
    return true;
  }

  if (click == 1 && !emailRegex.test(inputFieldValue)) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML = "Please enter a valid email id.";
    inputField.focus();
    return false;
  } else if (click == 1) {
    errorMsg.innerHTML = "";
    inputField.style.borderColor = "#9ecaed";
    console.log("into second if");
    return true;
  }

  if (click == 2 && inputFieldValue.length < 8) {
    console.log("8 char if");
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML = "Password length should be grater than 8 charcters.";
    inputField.focus();
    return false;
  } else if (
    click == 2 &&
    (inputFieldValue.search(/[A-Z]/) == -1 ||
      inputFieldValue.search(/[a-z]/) == -1 ||
      inputFieldValue.search(/[0-9]/) == -1)
  ) {
    console.log("num, lower and upper");
    inputField.style.borderColor = "orange";
    errorMsg.innerHTML =
      "Password should contains lowercase, uppercase and numbers.";
    inputField.focus();
    return false;
  } else if (click == 2) {
    localStorage.setItem("password", inputFieldValue);
    errorMsg.innerHTML = "";
    inputField.style.borderColor = "green";
    return true;
  }

  if (
    click == 3 &&
    (inputFieldValue.search(/[A-Z]/) == -1 ||
      inputFieldValue.search(/[a-z]/) == -1 ||
      inputFieldValue.search(/[0-9]/) == -1) &&
    inputFieldValue.length < 8
  ) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML =
      "Password should contains lowercase, uppercase and numbers.";
    inputField.focus();
    return false;
  } else if (
    click == 3 &&
    localStorage.getItem("password") != inputFieldValue
  ) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML = "Password mis-matched !!!";
    inputField.focus();
    return false;
  } else if (click == 3) {
    errorMsg.innerHTML = "";
    inputField.style.borderColor = "green";
    return true;
  }

  if (click == 4 && isNaN(inputFieldValue)) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML = "Phone number should contains only digits 0 - 9.";
    inputField.focus();
    return false;
  } else if (click == 4 && inputFieldValue.length < 10) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML =
      "Password should contains lowercase, uppercase and numbers.";
    inputField.focus();
    return false;
  } else if (click == 4) {
    errorMsg.innerHTML = "";
    inputField.style.borderColor = "green";
    return true;
  }

  if (click == 6 && !vehicalNumberRegex.test(inputFieldValue)) {
    inputField.style.borderColor = "tomato";
    errorMsg.innerHTML = "Enter a valid vehicle number (ex. RJ009955)";
    inputField.focus();
    return false;
  } else if (click == 6) {
    errorMsg.innerHTML = "";
    inputField.style.borderColor = "green";
    return true;
  }
}

function changeInputField() {
  let inputField = document.getElementById("input-field");
  let message = document.getElementById("message");
  let messageVehicalForm = document.getElementById("message-vehical-form");
  let fields = document.getElementById("fields");
  let vehicleTypes = document.getElementById("vehicle-types");

  if (click == 0) {
    if (validateField()) {
      click = click + 1;
      localStorage.setItem("name", inputField.value);
      message.innerHTML =
        "Hello " + inputField.value + ", Enter your email please.";
      inputField.value = "";
      inputField.type = "email";
      inputField.placeholder = "Enter email here";
      inputField.onkeyup = validateField;
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 1) {
    if (validateField()) {
      click = click + 1;
      message.innerHTML =
        "Well done " +
        localStorage.getItem("name") +
        ", now create a strong\npassword to keep your account safe.";
      inputField.value = "";
      inputField.type = "password";
      inputField.placeholder = "Enter password here";
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 2) {
    if (validateField()) {
      click = click + 1;
      message.innerHTML = "Please confirm your password.";
      inputField.value = "";
      inputField.type = "password";
      inputField.placeholder = "Re-Enter password here";
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 3) {
    if (validateField()) {
      click = click + 1;
      message.innerHTML = "Let's share your contact detailes now";
      inputField.value = "";
      inputField.type = "text";
      inputField.placeholder = "Enter your phone number";
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 4) {
    if (validateField()) {
      click = click + 1;
      alert(localStorage.getItem("name") + ", You registered successfully.");
      message.innerHTML = "Register your vehicle now";
      inputField.value = "";
      inputField.type = "text";
      inputField.placeholder = "Enter vehicle name";
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 5) {
    if (validateField()) {
      click = click + 1;
      message.innerHTML = "Enter vehicle number now";
      inputField.value = "";
      inputField.type = "text";
      inputField.placeholder = "Vehicle number (ex. RJ002233)";
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 6) {
    if (validateField()) {
      click = click + 1;
      message.innerHTML = "Enter company name of your vehicle";
      inputField.value = "";
      inputField.type = "text";
      inputField.placeholder = "Vehicle company name";
    } else {
      inputField.borderColor = "tomato";
      inputField.focus();
    }
  } else if (click == 7) {
    click = click + 1;
    message.innerHTML =
      "Enter identification details (if any), or press enter to skip.";
    inputField.value = "";
    inputField.type = "text";
    inputField.placeholder = "Identification";
  } else if (click == 8) {
    click = click + 1;
    messageVehicalForm.innerHTML = "Please choose your vehical type.";
    fields.style.display = "none";
    vehicleTypes.style.display = "block";
  }
}

function getPrices(id) {
  document.getElementById("fields").style.display = "none";
  document.getElementById("vehicle-types").style.display = "none";
  document.getElementById("pricing").style.display = "block";
  document.getElementById("currency-types").style.display = "block";

  let daily = document.getElementById("daily");
  let monthly = document.getElementById("monthly");
  let yearly = document.getElementById("yearly");

  if ((id = "cycle")) {
    document.getElementById("cycle").className = "";
    daily.innerHTML = "Rs. 5";
    monthly.innerHTML = "Rs. 100";
    yearly.innerHTML = "Rs. 500";
  } else if ((id = "bike")) {
    daily.innerHTML = "Rs. 10";
    monthly.innerHTML = "Rs. 200";
    yearly.innerHTML = "Rs. 1000";
  } else if ((id = "car")) {
    daily.innerHTML = "Rs. 20";
    monthly.innerHTML = "Rs. 500";
    yearly.innerHTML = "Rs. 3500";
  }
}

function getPass(id) {
  let daily = document.getElementById("daily");
  let monthly = document.getElementById("monthly");
  let yearly = document.getElementById("yearly");
  let price;

  if (id == "daily") {
    monthly.className = "bt-field";
    yearly.className = "bt-field";

    daily.className = "bt-get-pass";
    price = daily.innerHTML;
  } else if (id == "monthly") {
    daily.className = "bt-field";
    yearly.className = "bt-field";

    monthly.className = "bt-get-pass";
    price = monthly.innerHTML;
  } else if (id == "yearly") {
    daily.className = "bt-field";
    monthly.className = "bt-field";

    yearly.className = "bt-get-pass";
    price = yearly.innerHTML;
  }

  localStorage.setItem("pass-price", price);
}

function getCurrency() {
  document.getElementById("pricing").style.display = "none";
  document.getElementById("currency-types").style.display = "none";
  document.getElementById("final-pass").style.display = "block";

  let pass = document.getElementById("pass");
  let currency = document.getElementById("currency").value;
  let passPrice = localStorage.getItem("pass-price");
  passPrice = passPrice.slice(4);

  if (currency == "USD") {
    passPrice = passPrice * 0.014;
    pass.innerHTML = `Your Pass Price : ${passPrice} $.`;
  } else if (currency == "YEN") {
    passPrice = passPrice * 1.51;
    pass.innerHTML = `Your Pass Price : ${finalPrice} Yen.`;
  } else {
    pass.innerHTML = `Your Pass Price : ${finalPrice} rupees.`;
  }
}
