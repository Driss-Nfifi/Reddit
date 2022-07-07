elemt=document.getElementById("comments")
username=document.getElementById("usernameSubject")
function myFunction() {

    if (elemt.style.display === "none") {
        elemt.style.display = "block";
    } else {
        elemt.style.display = "none";
    }
}

function f(comment,margin) {
    //var iDiv = document.createElement('div');
    var replyDiv = document.createElement('div');
    replyDiv.id = comment.id;
    if("ce commentaire est supprimer"==comment.description){
        replyDiv.innerHTML="("+ comment.user.username +")      \n"+comment.description

    }
    else {
        replyDiv.innerHTML="("+ comment.user.username +")      \n"+comment.description
        creatReply(replyDiv,comment)
    }
    replyDiv.style.marginLeft=margin+"px"

    elemt.append(replyDiv)
    if(comment.comments.length!=0){
        seeComment(comment.comments,margin+20)
    }
}

function seeComment(comment,margin) {
    for (i=0;i<comment.length;i++){
        //alert(comment[i].description)
        f(comment[i],margin)
    }
}
function comments(comments,margin){
    try {
        ac = document.getElementById('comment1');
        ac.action="../../Comment/addComment/"+subject_id+"/"+username.innerHTML
        for (let i=0;i<comments.length;i++){
            //alert(i)
            f(comments[i],margin)
            //f(comment[1],margin)
        }
        myFunction();
    }
    catch (e){}


}


function creatReply(replyDiv,comment) {
    replyDiv.className="reply-section"
    var row = document.createElement('div');
    row.className="d-flex flex-row align-items-center voting-icons"
    var iUp= document.createElement('a');
    iUp.href="../../Comment/voteUp/"+subject_id+"/"+comment.id+"/"+username.innerHTML
    iUp.className="fa fa-sort-up fa-2x mt-3 hit-voting"
    var iDown= document.createElement('a');
    iDown.className="fa fa-sort-down fa-2x mb-3 hit-voting"
    iDown.href="../../Comment/voteDown/"+subject_id+"/"+comment.id+"/"+username.innerHTML
    replyDiv.append(row)

    var buttonDelete=document.createElement('a');
    buttonDelete.className="btn btn-primary"
    buttonDelete.innerHTML="delete"

       replyDiv.append(buttonDelete)
    try {
            buttonDelete.href = "../../Comment/deleteComment/"+username.innerHTML+"/"+comment.id+"/"+subject_id
         }
        catch (e){

        }

    row.append(iUp)
    row.append(iDown)
    var spansize=document.createElement('span');
    spansize.innerHTML=comment.vote;
    var buttonrep=document.createElement('button');
    buttonrep.className="btn btn-link"
    buttonrep.innerHTML="  Reply "+"  ("+ comment.comments.length+")"
    row.append(spansize)
    row.append(buttonrep)
    var divForm = document.createElement('form');
    row.append(divForm);
    var id="divForm"+comment.id
    divForm.id=id
    divForm.className="d-flex flex-row add-comment-section mt-4 mb-4"
    divForm.style.visibility = "hidden";
    divForm.method="post"
    try {
        divForm
        divForm.action="../../Comment/addCommentinComment/"+username.innerHTML+"/"+subject_id+"/"+comment.id;
    }
    catch (e){

    }


    //buttonrep.addEventListener('click',showrep(id));
    buttonrep.onclick=function (){showrep(id)}
    //divForm.style.display = "none"
    var inputform= document.createElement('input');
    inputform.name="description"
    inputform.type="text"
    var button=document.createElement('button');
    button.className="btn btn-primary"
    button.innerHTML="Comment"




    divForm.append(inputform)
    divForm.append(button);
}


function showrep(id){
    //alert(id)
    var divForm = document.getElementById(id);
    //alert("imad")
    if (divForm.style.visibility == "hidden") {
        divForm.style.visibility = "visible";
    } else {
        divForm.style.visibility = "hidden";
    }
}




/*
 <div class="d-flex flex-row add-comment-section mt-4 mb-4">
    <input type="text" class="form-control mr-3" placeholder="Add comment">
    <button class="btn btn-primary" type="button">Comment</button>
 </div>
 */
