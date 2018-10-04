<div class="container">

	<div class="row">

		<!--  would be to dispaly sidebar*/-->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!--  would be to dispaly products*/-->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">

						<script>
							window.categoryId = ' ';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-bordered" >
						<thead>
							<tr>
								<td></td>
								<td>Name</td>
								<td>Brand</td>
								<td>Unit Price</td>
								<td>Qnt. Available</td>
								<td>Action</td>
							</tr>

						</thead>
						<tfoot>
							<tr>
								<td></td>
								<td>Name</td>
								<td>Brand</td>
								<td>Unit Price</td>
								<td>Qnt. Available</td>
								<td>Action</td>
							</tr>

						</tfoot>

					</table>

				</div>


			</div>
		</div>


	</div>

</div>