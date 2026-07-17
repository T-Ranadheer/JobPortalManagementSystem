/*==================================
      JOB SEEKER DASHBOARD
===================================*/

document.addEventListener("DOMContentLoaded", function () {

    console.log("Job Seeker Dashboard Loaded");

    // Welcome Greeting
    const hour = new Date().getHours();

    let greeting = "";

    if (hour < 12) {
        greeting = "Good Morning";
    }
    else if (hour < 17) {
        greeting = "Good Afternoon";
    }
    else {
        greeting = "Good Evening";
    }

    const title = document.querySelector(".topbar h3");

    if (title) {
        title.innerHTML = greeting + " 👋";
    }

    // Dashboard Card Animation
    const cards = document.querySelectorAll(".dashboard-card");

    cards.forEach((card, index) => {

        card.style.opacity = "0";
        card.style.transform = "translateY(40px)";

        setTimeout(() => {

            card.style.transition = "0.6s";

            card.style.opacity = "1";

            card.style.transform = "translateY(0)";

        }, index * 200);

    });

});