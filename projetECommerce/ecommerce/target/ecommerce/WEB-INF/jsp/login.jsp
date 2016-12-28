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
					<div class="signin-rit">
						<span class="checkbox1">
							 <label class="checkbox"><input type="checkbox" name="checkbox" checked="">Mot de passe oublié</label>
						</span>
						<p><a href="#">Ici</a> </p>
						<div class="clearfix"> </div>
					</div>
					<form:form 	id="form"
								method="POST"
								action="/ecommerce/login/send" modelAttribute="titi">
						<div class="log-input">
							<div class="log-input-left">
							   <form:input type="text" class="user" path="pseudo" value="Pseudo" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Pseudo';}"/>
							</div>
							<span class="checkbox2">
								 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i></label>
							</span>
							<div class="clearfix"> </div>
						</div>
						<div class="log-input">
							<div class="log-input-left">
							   <form:input type="password" class="lock" path="password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email address:';}"/>
							</div>
							<span class="checkbox2">
								 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i></label>
							</span>
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