<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

	<section>
	<div id="page-wrapper" class="sign-in-wrapper">
		<div class="graphs">
			<div class="sign-in-form">
				<div class="sign-in-form-top">
					<h1>${connexion }</h1>
				</div>
				<div class="signin">
					
					<form:form 	id="form"
								method="POST"
								action="/ecommerce/login/send" modelAttribute="loginForm">
						<div class="log-input">
							<div class="log-input">
							   <form:input type="text" class="user" path="pseudoLogin" value="Pseudo" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Pseudo';}"/>
							   <form:errors path="pseudoLogin" style="color:Red"/>
							</div>
							
							<div class="clearfix"> </div>
						</div>
						<div class="log-input">
							<div class="log-input">
							   <form:input type="password" class="lock" path="passwordLogin" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email address:';}"/>
							   <form:errors path="passwordLogin" style="color:Red"/>
							</div>
							
							<div class="clearfix"> </div>
						</div>
						<input type="submit" value="${connexion}">
					</form:form>	 
				</div>
				<div class="new_people">
					<h2>${newPeople}</h2>
					<p>${newPeopleSec}</p>
					<a href="<spring:url value='/register' />">${registerNow }</a>
				</div>
			</div>
		</div>
	</div>
</section>