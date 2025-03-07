<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<!DOCTYPE html>
<html>
<body>
	<h1 style="color: blue; text-align: center;">Employee registration form</h1>

	<frm:form modelAttribute="emp">
		<table border="0" bgcolor="cyan" align="center">
			<tr>
				<td>Enter Employee Name::</td>
				<td><frm:input path="ename" /></td>
			</tr>
			<tr>
				<td>Enter Employee Job::</td>
				<td><frm:input path="job" /></td>
			</tr>
			<tr>
				<td>Enter Employee Salary::</td>
				<td><frm:input path="sal" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>