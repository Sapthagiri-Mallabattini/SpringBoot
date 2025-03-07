<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<h1 style="color: blue; text-align: center;">Employee edit form</h1>

<script lang="JavaScript" src="js/validation.js">
	
</script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<body>
	<frm:form modelAttribute="emp" onsubmit="return validation(this)">
		<table border="0" bgcolor="yellow" align="center">
			<tr>
				<td>Employee No::</td>
				<td><frm:input path="empno" readonly="true" /></td>
			</tr>
			<tr>
				<td>Employee Name::</td>
				<td><frm:input path="ename" /> <frm:errors path="ename" cssStyle="color:red;" /><span id="enameErr" /></td>
			</tr>
			<tr>
				<td>Employee Job::</td>
				<td><frm:input path="job" /> <frm:errors path="job" cssStyle="color:red;" /><span id="jobErr" /></td>
			</tr>
			<tr>
				<td>Employee Salary::</td>
				<td><frm:input path="sal" /> <frm:errors path="sal" cssStyle="color:red;" /><span id="salErr" /></td>
			</tr>
			<tr>
				<td>Department Number::</td>
				<td><frm:select path="deptno">
						<frm:options items="${dnoList}" />
					</frm:select> <frm:errors path="deptno" cssStyle="color:red;" /><span id="deptnoErr" /></td>
			</tr>
			<tr>
				<td><frm:hidden path="vflag1" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit Employee"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>