
function validation(frm){
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	document.getElementById("deptnoErr").innerHTML="";
	
	let name=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	let dno=frm.deptno.value;
	
	let vflag=true;
	if(name==""||name.length==0){
		document.getElementById("enameErr").innerHTML="Employee name is mandatory(cs)";
		vflag=false;
	}
	else if(name.length<5||name.length>15){
		document.getElementById("enameErr").innerHTML="Employee name must have minimum of 5 chars and maximum of 5 chars";
		vflag=false;
	}
	
	if(job==""||job.length==0){
		document.getElementById("jobErr").innerHTML="Employee job is mandatory(cs)";
		vflag=false;
	}
	else if(job.length<4||job.length>10){
		document.getElementById("jobErr").innerHTML="Employee job must have minimum of 4 chars and maximum of 10 chars";
	}
	
	if(sal==""||sal.length==0){
		document.getElementById("salErr").innerHTML="Employee salary is mandatory(cs)";
		vflag=false;
	}
	else if(isNaN(sal)){
		document.getElementById("salErr").innerHTML="Employee salary must be numeric value";
		vflag=false;
	}
	else if(sal<10000||sal>200000){
		document.getElementById("salErr").innerHTML="Employee salary must be there b/w 10000 to 200000";
		vflag=false;
	}
		
	if(dno==""||dno.length==0){
		document.getElementById("deptnoErr").innerHTML="Employee deptno is mandatory(cs)";
		vflag=false;
	}
	
		frm.vflag1.value="yes";
		
	return vflag;
	
}