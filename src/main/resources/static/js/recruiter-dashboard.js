document.addEventListener("DOMContentLoaded", function () {

    // Animate Cards
    const cards = document.querySelectorAll(".card");

    cards.forEach((card, index) => {

        card.style.opacity = "0";
        card.style.transform = "translateY(30px)";

        setTimeout(() => {

            card.style.transition = "0.5s";

            card.style.opacity = "1";

            card.style.transform = "translateY(0)";

        }, index * 150);

    });

    // Welcome Message
    let hour = new Date().getHours();

    let message = "";

    if (hour < 12)
        message = "Good Morning Recruiter ☀️";
    else if (hour < 17)
        message = "Good Afternoon Recruiter 🌤️";
    else
        message = "Good Evening Recruiter 🌙";

    console.log(message);

});