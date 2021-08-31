window.onload = function(){
	
	//왼쪽사이드
	var bsOffcanvas = new bootstrap.Offcanvas($("#offcanvasScrolling"));
	//서버 보낼 데이터
	var geoJsonData = null;
	
	var mapData;
	function getMapData() {
		$.ajax({
			type:'get',  
			url:'/mapData',  
			dataType: 'JSON',
			async: false,
			success : function(data){
				console.log(data.features[0].geometry.coordinates);
				
				if(null != data && undefined != data && data.features.length > 0){
					for (var i = 0; i < data.features.length; i++) {
						data.features[i].geometry.coordinates = JSON.parse(data.features[i].geometry.coordinates);
					}
					mapData = data;
				}
			}
		});
	}
	
	
    mapboxgl.accessToken = 'pk.eyJ1IjoiMnZlcnNlIiwiYSI6ImNrcmRrbTNhbjN0NW0yb3J6cGNkamkwcDAifQ.t8PYasBN9mAiYGvzd9_Ufw';
    var map = new mapboxgl.Map({
        container: 'map',
//        style: 'mapbox://styles/mapbox/streets-v11', //위성 3d
//        style: 'mapbox://styles/2verse/ckshmqk630abm17qmq53aal07', //그냥 3d
//        style: 'mapbox://styles/2verse/ckshha00xiz2517qwoy4omi82', //그냥 3d
        style: 'mapbox://styles/2verse/ckst8wpz32sc319p9y452hvw9',
//        style: 'mapbox://styles/2verse/ckslbtctq9uy417pd18hon6f8',
        center:  [
            127.101414,
            37.512579
          ], zoom: 16, pitch: 45,
      });
	//마커찍기
//    var testdata = function() {
//    	map.addLayer({
//   		 id: 'points-of-interest',
//   		 source: {
//   		 type: 'vector',
//   		 url: 'mapbox://mapbox.mapbox-streets-v8'
//   		 },
//   		 'source-layer': 'poi_label',
//   		 type: 'circle',
//   		 paint: {
//   		 // Mapbox Style Specification paint properties
//   		 },
//   		 layout: {
//   		 // Mapbox Style Specification layout properties
//   		 }
//   		 });
//	}
    	
	var marker = new mapboxgl.Marker()
	.setLngLat([126.97826714653111, 37.56773413818753])
	.setPopup(new mapboxgl.Popup().setHTML('<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">우리집</button>'))

	.addTo(map);
	
	 $('#selected_satellite').click(function() {
		 map.setStyle('mapbox://styles/mapbox/satellite-v9');
		 console.log(map.getStyle().layers);
	 });
	
	 
	 $('#selected_2d').click(function() {
		 map.setStyle('mapbox://styles/mapbox/streets-v11');
		 console.log(map.getStyle().layers);
		 console.log(map.getSource('earthquakes'))
		 
	 });
	 
	 $('#selected_3d').click(function() {
		 map.setStyle('mapbox://styles/2verse/ckshha00xiz2517qwoy4omi82');
		 console.log(map.getStyle().layers);
	 });
	 map.on('styledataloading', (e) => {
		 });
	 map.on('styledata', (e) => {
		
	 });
	 
	    var testdata = function() {
	    	map.addLayer({
	   		 id: 'points-of-interest',
	   		 source: {
	   		 type: 'vector',
	   		 url: 'mapbox://mapbox.mapbox-streets-v8'
	   		 },
	   		 'source-layer': 'poi_label',
	   		 type: 'circle',
	   		 paint: {
	   		 // Mapbox Style Specification paint properties
	   		 },
	   		 layout: {
	   		 // Mapbox Style Specification layout properties
	   		 }
	   		 });
		}
	map.on('idle', () => {
//		 console.log( map.loaded());
//		 if(map.loaded)
//			 testdata();
	 });
	map.on('load', function() {
		console.log("리셋");
		getMapData();
		
		map.addSource('earthquakes', {
			type: 'geojson',
			// Use a URL for the value for the `data` property.
			data: mapData
		});
		
	      console.log(map.getSource('earthquakes')._data.features);
		  
		  map.addLayer({
			'id': 'state-fills',
			'type': 'fill',
			'source': 'composite',
			'source-layer': 'building',
			'filter':[ "all", ["!=", ["get", "type"], "building:part"],[ "==", ["get", "underground"],"false"]],
			'layout': {},
			'paint': {
			  'fill-color': '#627BC1',
			  'fill-opacity': [
			    'case',
			    ['boolean', ['feature-state', 'hover'], false],
			    0.5,
			    0
			  ]
			}
		  });
		  map.addLayer(
		            {
		                'id': '3d-buildings', 'source': 'earthquakes',
		                'type': 'fill-extrusion',
		                'minzoom': 15,
		                'paint': {
		                    'fill-extrusion-color': '#aaa',
	
		                    // zoom 할 때 건물이 부드럽게 표시되도록 보간법(interpolate)을 사용
		                    'fill-extrusion-height': [
		                        'interpolate', ['linear'], ['zoom'],
		                        15, 0, 15.05,
		                        ['get', 'height']
		                    ],
		                    'fill-extrusion-base': [
		                        'interpolate', ['linear'], ['zoom'],
		                        15, 0, 15.05,
		                        ['get', 'min_height']
		                    ]
		                }
		            }
		        );
		    var selectedId = null;
	        map.on('mousemove', 'state-fills', (e) => {
	        	if(e.features[0].id != null && e.features[0].id != undefined){
		        	if(selectedId == null){
		        		selectedId = e.features[0].id;
		        	}
		        	if(selectedId == e.features[0].id){
			        	map.setFeatureState(
								{sourceLayer: 'building', source: 'composite', id: e.features[0].id},
								{ hover : true }
		        			);
		        	}else{
		        		map.setFeatureState(
								{sourceLayer: 'building', source: 'composite', id: selectedId},
								{ hover : false }
		        			);
		        		selectedId = e.features[0].id;
		        	}
	        	}
	        });
			map.on('mouseleave', '3d-buildings', () => {});
			

	        map.on('click','state-fills',  (e) => {
	        	
//	        	map.getSource('earthquakes')._data.features.push(
//	        			{
//	        				"id" : e.features[0].id,
//	        				"geometry" : e.features[0].geometry,
//	        				"type" : "feature",
//	        				"properties" : e.features[0].properties
//	        			}
//	        			);
	        	console.log(map.queryRenderedFeatures({ layers: ['state-fills'] }));
	        	console.log(map.getSource('composite'));
	        	console.log(map.getSource('earthquakes'));
	        	for (var i = 0; i < e.features.length; i++) {
					console.log(e.features[i]);
				}
	        	
	        	/*
	        	 * TODO
	        	 * 클릭 시 좌표가 두종류가 잡힘 처리해야함	        		
	        	*/
//	        	console.log(map.getStyle().layers);
	        	
	        	//화면 줌확인
        		if(15 < map.getZoom() < 16){
        			map.flyTo({
	        			center: e.lngLat,
	        			essential: true,
	        			speed: 0.5,
	        			zoom: 17});
        		}
	        	if(e.features[0].id != null && e.features[0].id != undefined){
	        		
	        		geoJsonData = e.features[0];
	        		console.log(e.features[0].geometry);
	        		//센터 좌표 가져오기!!!!!!!!!!!!!!!!!!!!!!!!!!!
	        		var test = turf.points(e.features[0].geometry.coordinates[0]);
	        		var center = turf.center(test);
		        	//자산번호 가져오기
	        		$('#assets_number').text(e.features[0].id);
		        	//왼쪽 사이드 메뉴 나오기
	        		bsOffcanvas.show();
	        		//클릭 시 중앙으로 이동
	        		map.flyTo({
	        			center: center.geometry.coordinates,
	        			essential: true,
	        			speed: 0.5,
	        			zoom: 17});
	        		//hover
	        		map.setFeatureState(
						{sourceLayer: 'building', source: 'composite', id: e.features[0].id },
						{ hover : true }
        			);
	        	}
//	        		offcanvasList.toggle();
//	        	console.log(center.geometry.coordinates[0]);
//				new mapboxgl.Popup({ closeOnClick: true })
////				.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat])
//				.setLngLat([center.geometry.coordinates[0],center.geometry.coordinates[1]])
//				.addTo(map);
//				var marker = new mapboxgl.Marker()
//				.setLngLat([center.geometry.coordinates[0],center.geometry.coordinates[1]])
//				.setPopup(new mapboxgl.Popup().setHTML('<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">우리집</button>'))
//
//				.addTo(map);
				 
//				   console.log(map.setFeatureState({sourceLayer: 'building', source: 'composite', id: e.features[0].id }));
//				   console.log(map.getSource('composite'));
//				   console.log(map.getSource('mapbox.mapbox-streets-v8'));
//				   console.log(e.features[0].properties)
//				map.setPaintProperty(
//		        		'building-extrusion',
//		        		'fill-extrusion-opacity',
//		        		0.2
//		        		);
//				 popup.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat]).setHTML(e.features[0].id).addTo(map);
						 
			});
	        
//	        const popup = new mapboxgl.Popup({
//	        	closeButton: false,
//	        	closeOnClick: false
//	        	});

	        map.on('mouseenter', '3d-buildings', (e) => {
	        // Change the cursor style as a UI indicator.
//	        map.getCanvas().style.cursor = 'pointer';
//	        const coordinates = e.features[0].geometry.coordinates.slice();
//	        const description = e.features[0].properties.description;
//	        while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) {
//	        coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
	        
	        });
	        
    });
  	$('#buyCheckOkBtn').click(function(){ //구매 확인
  		console.log(geoJsonData);
  		let sendData = getGeoJson(geoJsonData);
  		console.log(sendData);
  		$.ajax({
  			type:'post',  
  			url:'/buyABuilding',  
  			data:JSON.stringify(sendData),   
  			dataType: 'json',
  			contentType: "application/json; charset:UTF-8",
  			success : function(data){
  				console.log(data);
  				if(data === true){
  					$('.btn-close').click();
  					getMapData();
  					map.getSource('earthquakes').setData(mapData);
  					
				}
			}
  		});
     });
  	var getGeoJson = function(geoJsonData) { //구매 시
		return {
			"id" : geoJsonData.id,
			"type" : geoJsonData.type,
			"properties" : {
				"extrude": geoJsonData.properties.extrude,
				"height": geoJsonData.properties.height,
				"iso_3166_1": geoJsonData.properties.iso_3166_1,
				"iso_3166_2": geoJsonData.properties.iso_3166_2,
				"min_height": geoJsonData.properties.min_height,
				"type": geoJsonData.properties.type,
				"underground": geoJsonData.properties.underground
			},
			"geometry" : geoJsonData.geometry.coordinates,
			"nickname" : $('#real_estate_nickname').text(),
			"price" : $('#real_estate_price').text()
		}
	}
	  	
}
