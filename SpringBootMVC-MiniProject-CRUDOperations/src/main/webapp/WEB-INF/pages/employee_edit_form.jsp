<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<!DOCTYPE html>
<html>
<body>
	<h1 style="color: blue; text-align: center;">Employee edit form</h1>

	<frm:form modelAttribute="emp">
		<table border="0" bgcolor="yellow" align="center">
			<tr>
				<td>Employee No::</td>
				<td><frm:input path="empno" readonly="true" /></td>
			</tr>
			<tr>
				<td>Employee Name::</td>
				<td><frm:input path="ename" /></td>
			</tr>
			<tr>
				<td>Employee Job::</td>
				<td><frm:input path="job" /></td>
			</tr>
			<tr>
				<td>Employee Salary::</td>
				<td><frm:input path="sal" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit Employee"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>