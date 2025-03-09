<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 style="color: red; text-align: center;"><sp:message code="customer.register.title"/></h1>

<h1 style="color: red;text-align: center;">Current active Locale is::${pageContext.response.locale}</h1>
<center>
<fmt:setLocale value="${pageContext.response.locale}"/>
<jsp:useBean id="dt" class="java.util.Date"/>

<fmt:formatDate var="fdt" value="${dt}" type="both" dateStyle="SHORT" timeStyle="SHORT"/>
<b style="color: blue;">The Formatted Date Value::${fdt}</b>

<br><br>
<fmt:formatNumber var="fnumber" value="5656356265" type="number"/>
<b style="color: green;">Formatted number is::${fnumber}</b>

<br><br>
<fmt:formatNumber var="fcurrency" value="5656356265" type="currency"/>
<b style="color: green;">Formatted currency is::${fcurrency}</b>

<br><br>
<fmt:formatNumber var="fpercentage" value="0.22" type="percent"/>
<b style="color: orange;">Formatted Percentage is::${fpercentage}</b>

</center>
<frm:form modelAttribute="cust">
	<table border="0" align="center">
		<tr>
			<td><sp:message code="customer.register.name"/></td>
			<td><frm:input path="cname"/></td>
		</tr>
		<tr>
			<td><sp:message code="customer.register.address"/></td>
			<td><frm:input path="cadd"/></td>
		</tr>
		<tr>
			<td><sp:message code="customer.register.billAmt"/></td>
			<td><frm:input path="billAmt"/></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="<sp:message code="customer.button.caption"/>"></td>
		</tr>
	</table>
</frm:form>
<br><br>

<p style="text-align: center;">
	<a href="?lang=en_US">English</a> &nbsp;&nbsp;
	<a href="?lang=fr_FR">French</a> &nbsp;&nbsp;
	<a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;
	<a href="?lang=zh_CN">Chineese</a> &nbsp;&nbsp;
	<a href="?lang=de_DE">Garman</a> &nbsp;&nbsp;
</p>