<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<section>
	<div id="page-wrapper" class="sign-in-wrapper">
		<div class="graphs">
			<div class="sign-up">
				<h1>Inscrivez-vous</h1>
				<p class="creating">Commandez et profitez de plein d'avantages.</p>
				<form:form  id="form"
							method="POST"
							action="/ecommerce/register/sendRegister"
							modelAttribute="registerForm">
				<h2>Informations personnelles</h2>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Nom* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="lastName"/>
							<form:errors path="lastName" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Prénom* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="firstName"/>
							<form:errors path="firstName" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Date de Naissance* :</h4>
						</div>
						<div class="sign-up2">
							<form:input  placeholder="19-02-1995" required=" " path="birthDate" type="date"/>
							<form:errors path="birthDate" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Téléphone :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="phoneNumber"/>
							<form:errors path="phoneNumber" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<h2>Adresse de livraison</h2>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Pays* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="country"/>
							<form:errors path="country" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Rue* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="street"/>
							<form:errors path="street" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Numéro* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="number" min="1" max="10000" placeholder=" " required=" " path="numberOfStreet"/>
							<form:errors path="numberOfStreet" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Code postal* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="number" placeholder=" " required=" " path="zipCode"/>
							<form:errors path="zipCode" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Ville* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="city"/>
							<form:errors path="city" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					
					<h2>Identifiants</h2>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Email* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="eMail"/>
							<form:errors path="eMail" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Pseudo* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="pseudo"/>
							<form:errors path="pseudo" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Mot de passe* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="password" placeholder=" " required=" " path="password"/>
							<form:errors path="password" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Confirmation* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="password" placeholder=" " required=" " path="passwordConfirmation"/>
							<form:errors path="passwordConfirmation" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sub_home">
						<input type="submit" value="Create">
						
						<div class="clearfix"> </div>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
	</section>
	
	
	
	
	
	