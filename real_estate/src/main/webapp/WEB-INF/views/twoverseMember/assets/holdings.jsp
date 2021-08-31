<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
      <h1>Holdings</h1>
      <table class="table">
			<thead>
				<tr>
				   <th>Nation</th>
				   <th></th>
				   <th>Asset Name</th>
				   <th>Date</th>
				   <th>Price</th>
				   <th>Grade</th>
				   <th>Rate</th>
				   <th>Evaluation</th>
				   <th>Look</th>
				   <th>Offer</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
			        <c:when test = "${empty data }">
			         	<tr>
							<td colspan="10" class="text-center">
								No Data
							</td>
						</tr>
			        </c:when>
					<c:otherwise>
			            <c:forEach var ="i" items = "${data }">
							<tr>
							   <td>${i.nation}</td>
							   <td></td>
							   <td>${i.assetName}</td>
							   <td>${i.data}</td>
							   <td>${i.price}</td>
							   <td>${i.grade}</td>
							   <td>${i.rate}</td>
							   <td>${i.evaluation}</td>
							   <td>${i.look}</td>
							   <td>${i.offer}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody> 
		</table>
    </main>
