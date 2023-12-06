function init() {
    document.getElementById("bt-add-game").onclick=function (){
        document.getElementById("addGame").style.display="block";
    }
    document.getElementById("close-addGame").onclick=function () {
        document.getElementById("addGame").style.display="none";
    }
    document.getElementById("close-modifyGame").onclick=function () {
        document.getElementById("modifyGame").style.display="none";
    }
}
function modify(id) {
    console.log(id)
    document.getElementById("modify").innerHTML+=
    "<input type='hidden' name='id' value="+id+">";
    document.getElementById("modifyGame").style.display="block";
}