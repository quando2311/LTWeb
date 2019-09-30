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