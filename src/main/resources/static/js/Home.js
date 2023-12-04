function init() {
    document.getElementById("bt-add-game").onclick=function (){
        document.getElementById("addGame").style.display="block";
    }
    document.getElementById("close-addGame").onclick=function () {
        document.getElementById("addGame").style.display="none";
    }
}