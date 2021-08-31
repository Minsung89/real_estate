<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <main class="col-9 py-md-3 pl-md-5 bd-content l-main" role="main">
		<h1>History</h1>
		<table class="table">
			<thead>
				<tr>
				   <th>Sort</th>
				   <th>Nation</th>
				   <th></th>
				   <th>Asset Name</th>
				   <th>Date</th>
				   <th>Price</th>
				   <th>Deal</th>
				   <th>Grade</th>
				   <th>Proceeds</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
			        <c:when test = "${empty data }">
			         	<tr>
							<td colspan="9" class="text-center">
								No Data
							</td>
						</tr>
			        </c:when>
					<c:otherwise>
			            <c:forEach var ="i" items = "${data }">
							<tr>
							   <td>${i.sort}</td>
							   <td>${i.nation}</td>
							   <td></td>
							   <td>${i.assetName}</td>
							   <td>${i.data}</td>
							   <td>${i.price}</td>
							   <td>${i.deal}</td>
							   <td>${i.grade}</td>
							   <td>${i.proceeds}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody> 
		</table>
    </main>
