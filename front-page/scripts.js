//Event for menu dropdown

var menu_dropdown = document.getElementById("dropdown");
function showDropdown() {	  
  menu_dropdown.classList.toggle("show");
}

window.onclick = function(event){
    if(!event.target.matches('#drop')) {
        if(menu_dropdown.classList.contains('show')){
            menu_dropdown.classList.remove('show');
        }
    }
}

//end event for menu dropdown

//Slide show code
var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
    showSlides(slideIndex += n);
}


function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("slide");			
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    let slideStyle = slides[slideIndex-1].style;
    let headerContent = document.getElementById("header-content");
    let headerTitle = document.getElementById("header-title");
    let headerInside = document.getElementById("header-inside");
    let slideContainer = document.getElementsByClassName("slideshow-container")[0];
    let nextBtn = document.getElementsByClassName("next")[0];
    let prevBtn = document.getElementsByClassName("prev")[0];
    slideStyle.display = "block";
    slideStyle.backgroundImage = "url(img/img-" + slideIndex + ".jpg)";
    if(slideIndex-1 == 0){
        headerTitle.innerHTML = "POWER OF 10";	
        headerInside.innerHTML = "Express yourself way with Galaxy Note10 and Galaxy S10. Shoot like a pro. Edit on the go. Go all-day. That's the power of 10.";
        
        headerTitle.style.color = "black";
        headerInside.style.color = "black";
        
        headerContent.style.top = "5%";
        headerContent.style.left = "50%";
        headerContent.style.backgroundColor = "white";
        slideContainer.style.backgroundColor = "white";

        nextBtn.style.color = "black";
        prevBtn.style.color = "black";
    }
    else if(slideIndex-1 == 1){
        headerTitle.innerHTML = "GALAXY FOLD";
        headerInside.innerHTML = "A breakthrough display. A revolutionary dual battery. The Galaxy Fold has officially arrived.";
        
        headerTitle.style.color = "white";
        headerInside.style.color = "white";
        
        headerContent.style.top = "5%";
        headerContent.style.left = "5%";
        headerContent.style.backgroundColor = "black";
        slideContainer.style.backgroundColor = "black";

        nextBtn.style.color = "white";
        prevBtn.style.color = "white";
    }
}

//end slideshow code