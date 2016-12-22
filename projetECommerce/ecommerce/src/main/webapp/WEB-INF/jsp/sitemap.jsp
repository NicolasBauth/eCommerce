<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>

	<!-- Regions -->
		<div class="container">
			<h2 class="head">Sitemap</h2>
		</div>
		<div class="sitemap-regions">
			<div class="container">
				<div class="sitemap-region-grid">
					
					<c:forEach  items="${categories}" var="c">
						<div class="sitemap-region">
							<h4>${c.categoryTranslation}</h4>
								<ul>
									<c:forEach  items="${products[c.translatedCategory.categoryId]}" var="p">
										<li><a href="furnitures.html">${p.name}</a></li>
									</c:forEach>
								</ul>
						</div>
					</c:forEach>
					
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	<!-- //Regions -->