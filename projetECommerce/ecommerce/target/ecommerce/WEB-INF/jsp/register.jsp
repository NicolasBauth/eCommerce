<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

<section>
	<div id="page-wrapper" class="sign-in-wrapper">
		<div class="graphs">
			<div class="sign-up">
				<h1>${registerText }</h1>
				<p class="creating">${orderText }</p>
				<form:form  id="form"
							method="POST"
							action="/ecommerce/register/sendRegister"
							modelAttribute="registerForm">
				<h2>${personalInformationsText }</h2>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${lastNameText}* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="lastName"/>
							<form:errors path="lastName" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${firstNameText}* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="firstName"/>
							<form:errors path="firstName" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${birthdateText }*:</h4>
						</div>
						<div class="sign-up2">
							<form:input  placeholder="19-02-1995" required=" " path="birthDate" type="date"/>
							<form:errors path="birthDate" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${phoneNumberText } :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="phoneNumber"/>
							<form:errors path="phoneNumber" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<h2>${deliveryAdressText }</h2>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${countryText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="country"/>
							<form:errors path="country" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${streetText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="street"/>
							<form:errors path="street" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${numberText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="number" min="1" max="10000" placeholder=" " required=" " path="numberOfStreet"/>
							<form:errors path="numberOfStreet" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${zipCodeText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="number" placeholder=" " required=" " path="zipCode"/>
							<form:errors path="zipCode" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${cityText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="city"/>
							<form:errors path="city" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					
					<h2>${idText }</h2>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${emailText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="eMail"/>
							<form:errors path="eMail" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${userNameText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="pseudo"/>
							<form:errors path="pseudo" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${passwordText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="password" placeholder=" " required=" " path="password"/>
							<form:errors path="password" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>${confirmPasswordText }* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="password" placeholder=" " required=" " path="passwordConfirmation"/>
							<form:errors path="passwordConfirmation" style="color:Red"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sub_home">
						<input type="submit" value="${createText }">
						
						<div class="clearfix"> </div>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
	</section>
	
	
	
	
	
	