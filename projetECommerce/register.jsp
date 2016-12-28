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
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Prénom* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="firstName"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Date de Naissance* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="birthDate"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Téléphone* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="phoneNumber"/>
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
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Rue* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="street"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Numéro* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="numberOfStreet"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Code postal* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="zipCode"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Ville* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="city"/>
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
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Pseudo* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="text" placeholder=" " required=" " path="pseudo"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Mot de passe* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="password" placeholder=" " required=" " path="password"/>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Confirmation* :</h4>
						</div>
						<div class="sign-up2">
							<form:input type="password" placeholder=" " required=" " path="passwordConfirmation"/>
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
	
	
	
	
	
	
	<div class="contact main-grid-border">
		<div class="container">
			<h2 class="head text-center">Contact Us</h2>
			<section id="hire">    
				<form id="filldetails">
					  <div class="field name-box">
							<input type="text" id="name" placeholder="Who Are You?"/>
							<label for="name">Name</label>
							<span class="ss-icon">check</span>
					  </div>
					  
					  <div class="field email-box">
							<input type="text" id="email" placeholder="example@email.com"/>
							<label for="email">Email</label>
							<span class="ss-icon">check</span>
					  </div>
					  
					  <div class="field ad-ID">
							<input type="text" id="email" placeholder="Ad ID"/>
							<label for="email">Ad ID</label>
							<span class="ss-icon">check</span>
					  </div>
					  
					  <div class="field phonenum-box">
							<input type="text" id="email" placeholder="Phone Number"/>
							<label for="email">Phone</label>
							<span class="ss-icon">check</span>
					  </div>

					  <div class="field msg-box">
							<textarea id="msg" rows="4" placeholder="Your message goes here..."/></textarea>
							<label for="msg">Your Msg</label>
							<span class="ss-icon">check</span>
					  </div>

					 
			  </form>
			<div class="upload">
						 <h3 class="tlt">Add Attachment:</h3>
						<form id="upload" method="post" action="upload.php" enctype="multipart/form-data">
			<div id="drop">
				<a>Choose file</a>
				<input type="file" name="upl" multiple />
			</div>

			<ul class="show">
				<!-- The file uploads will be shown here -->
			</ul>
		</form>	
		<div class="clear"></div>
		<form class="submit">
		<input class="button" type="submit" value="Send" />
		</form>
		<!-- JavaScript Includes -->
		<script src="js/jquery.knob.js"></script>

		<!-- jQuery File Upload Dependencies -->
		<script src="js/jquery.ui.widget.js"></script>
		<script src="js/jquery.fileupload.js"></script>
		
		<!-- Our main JS file -->
		<script src="js/script.js"></script>
						</div>
			</section>
			<script>
				  $('textarea').blur(function () {
				$('#hire textarea').each(function () {
					$this = $(this);
					if (this.value != '') {
						$this.addClass('focused');
						$('textarea + label + span').css({ 'opacity': 1 });
					} else {
						$this.removeClass('focused');
						$('textarea + label + span').css({ 'opacity': 0 });
					}
				});
			});
			$('#hire .field:first-child input').blur(function () {
				$('#hire .field:first-child input').each(function () {
					$this = $(this);
					if (this.value != '') {
						$this.addClass('focused');
						$('.field:first-child input + label + span').css({ 'opacity': 1 });
					} else {
						$this.removeClass('focused');
						$('.field:first-child input + label + span').css({ 'opacity': 0 });
					}
				});
			});
			$('#hire .field:nth-child(2) input').blur(function () {
				$('#hire .field:nth-child(2) input').each(function () {
					$this = $(this);
					if (this.value != '') {
						$this.addClass('focused');
						$('.field:nth-child(2) input + label + span').css({ 'opacity': 1 });
					} else {
						$this.removeClass('focused');
						$('.field:nth-child(2) input + label + span').css({ 'opacity': 0 });
					}
				});
			});
			$('#hire .field:nth-child(3) input').blur(function () {
				$('#hire .field:nth-child(3) input').each(function () {
					$this = $(this);
					if (this.value != '') {
						$this.addClass('focused');
						$('.field:nth-child(3) input + label + span').css({ 'opacity': 1 });
					} else {
						$this.removeClass('focused');
						$('.field:nth-child(3) input + label + span').css({ 'opacity': 0 });
					}
				});
			});
			$('#hire .field:nth-child(4) input').blur(function () {
				$('#hire .field:nth-child(4) input').each(function () {
					$this = $(this);
					if (this.value != '') {
						$this.addClass('focused');
						$('.field:nth-child(4) input + label + span').css({ 'opacity': 1 });
					} else {
						$this.removeClass('focused');
						$('.field:nth-child(4) input + label + span').css({ 'opacity': 0 });
					}
				});
			});
		  //@ sourceURL=pen.js
		</script>    
		<script>
	  if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	  }
	</script>
		</div>	
	</div>