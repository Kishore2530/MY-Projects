function cathover() {
    var hov = document.getElementById("cat");
    hov.style.display = "block";
}
function cathov() {
    var hovout = document.getElementById("cat");
    hovout.style.display = "none";
}
function cathover1() {
    var hov1 = document.getElementById("cat");
    hov1.style.display = "block";
}
function cathov1() {
    var hovout1 = document.getElementById("cat");
    hovout1.style.display = "none";
}
function clicksearch() {
    var click = document.getElementById("innav5a");
    click.style.display = "block";
    var try1 = document.getElementById("innav4");
    try1.style.display = "none";
    var inp = document.getElementById("nav5inp")
    inp.style.display = "block"
}
function clicklog() {
    var enlan = document.getElementById("enlang");
    enlan.style.display = "block"
}
function search() {
    var try1 = document.getElementById("innav4")
    try1.style.display = "none"
    var search1 = document.getElementById("sea")
    search1.style.display = "block"
    var border = document.getElementById("innav6")
    border.style.border = "2px solid #8197a4"
}
var number = 0;
function logable1() {
    if (number === true) {
        var login = document.getElementById("login")
        login.style.display = "block"
        return 1;
    }
    else if(logable1() === 1)
    {
        var login1 = document.getElementById("login")
        login1.style.display = "none"
        return 0;
    }
}


