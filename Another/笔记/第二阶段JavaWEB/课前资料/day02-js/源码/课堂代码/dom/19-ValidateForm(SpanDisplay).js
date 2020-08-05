/*
	������Ϣ����
*/
function mouseIn(){
	var desc = document.getElementById("desc");
	if(desc.value == "������������Ϣ~��"){
		desc.value="";
	}
}
/*
	������Ϣ����
*/
function mouseOut(){
	var desc = document.getElementById("desc");
	if(desc.value == ""){
		desc.value="������������Ϣ~��";
	}
	checkDescription("������Ϣ����Ϊ��");
}

/*
	���ύʱ������У��
*/
function checkData(){
	var canSub = true;
	
	canSub = checkNull("username","�û�������Ϊ�գ�") && canSub;
	canSub = checkNull("password","���벻��Ϊ�գ�") && canSub;
	canSub = checkPassword2() && canSub;
	canSub = checkGender("�Ա���Ϊ��!") && canSub;
	canSub = checkNull("nickname","�ǳƲ���Ϊ�գ�") && canSub;
	canSub = checkEmail();
	canSub = checkLike("���ò���Ϊ�գ�") && canSub;
	canSub = checkNull("img","ͷ����Ϊ�գ�") && canSub;
	canSub = checkNull("valistr","��֤�벻��Ϊ�գ�") && canSub;
	canSub = checkDescription("������Ϣ����Ϊ�գ�") && canSub;
	
	return canSub;
}


/*
	����У�顪��ͨ�÷ǿ�У��
*/
function checkNull(name,msg){
	setMsg(name,"");
	var inp = document.getElementsByName(name)[0];
	if(inp.value ==null || inp.value == ""){
		setMsg(name,msg);
		return false;
	}
	return true;
}

/*
	����У�顪��ȷ������У��
*/
function checkPassword2(){
	checkNull("password2","ȷ�����벻��Ϊ�գ�");
	var password = document.getElementsByName("password")[0].value;
	var password2 = document.getElementsByName("password2")[0].value;
	if(password !='' && password2!='' && password!=password2){
		setMsg("password2","")
		setMsg("password2","�������벻һ��");
		return false;
	}
	return true;
}

/*
	����У�顪���Ա�ǿ�У��
*/
function checkGender(msg){
	setMsg("gender","");
	var genders = document.getElementsByName("gender");
	var gender_flag = false;
	for(var i = 0;i<genders.length;i++){
		if(genders[i].checked == true){
			gender_flag = true;
		}
	}
	if(gender_flag == false){
		setMsg("gender",msg);
	}
	return gender_flag;
}

/*
	����У�顪�����÷ǿ�У��
*/
function checkLike(msg){
	setMsg("like","");
	var likes = document.getElementsByName("like");
	var like_flag = false;
	for(var i = 0;i<likes.length;i++){
		if(likes[i].checked == true){
			like_flag = true;
		}
	}
	if(like_flag == false){
		setMsg("like",msg);
		return false;
	}
	return true;
	
}
/*
	����У�顪��������Ϣ�ǿ�У��
*/
function checkDescription(msg){
	setMsg("desc","");
	var desc = document.getElementsByName("desc")[0];
	if(desc.value == "������������Ϣ~��"){
		setMsg("desc",msg);
		return false;
	}
	return true;
}

/*
У�����ݡ���У������
xxxxx@xxxx.xx.xx.xx
^\w+@\w+(\.\w+)+$

��js��������ʽҲ��һ������
����һ��������ʽ����
	var reg = /^\w+@\w+(\.\w+)+$/;
	var reg = new RegExp("^\w+@\w+(\.\w+)+$");
*/
function checkEmail(){
checkNull("email","���䲻��Ϊ�գ�");
var email = document.getElementsByName("email")[0];
if(email.value!=""){
	setMsg("email","");
	if(!/^\w+@\w+(\.\w+)+$/.test(email.value)){
		setMsg("email","�����ʽ����ȷ");
		return false;
	}
}
return true;
}


function setMsg(name,msg){
	document.getElementById(name+"_msg").innerHTML="<font color='red' size='-1'>"+msg+"</font>";
}