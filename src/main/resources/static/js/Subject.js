var username=""
function  usernamefic(){
    try {
        username=document.getElementById("usernameAddSubject").innerHTML;
        document.getElementById("formadd").action="../../Subject/addSubjectFunction/"+username
    }
    catch (e){
        username=""
    }
}

function mysubs() {
    try{
        username=document.getElementById("usernameAddSubject").innerHTML;
        document.getElementById("mine").href="../../Subject/mySubjects/"+username
    }
    catch (e){
            username=""
    }

    function user(){
        return username
    }
}
