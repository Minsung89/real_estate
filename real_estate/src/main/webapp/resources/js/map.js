window.onload = function(){
//	mapboxgl.accessToken = 'pk.eyJ1IjoiMnZlcnNlIiwiYSI6ImNrcmRrbTNhbjN0NW0yb3J6cGNkamkwcDAifQ.t8PYasBN9mAiYGvzd9_Ufw';
//	//맵 기본 세팅
//	var map = new mapboxgl.Map({
//		container: 'map', // container ID
//		style: 'mapbox://styles/mapbox/streets-v11', // style URL
//		center: [126.97826714653111, 37.56773413818753], // starting position [lng, lat]
//		zoom: 9, // starting zoom
//		attributionControl: false
//		
//	})
//		.addControl(new mapboxgl.AttributionControl({
//			compact: true
//	}));
    mapboxgl.accessToken = 'pk.eyJ1IjoiMnZlcnNlIiwiYSI6ImNrcmRrbTNhbjN0NW0yb3J6cGNkamkwcDAifQ.t8PYasBN9mAiYGvzd9_Ufw';
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/2verse/ckrr4yn841pt719mpr80tkk0x',
        center: [126.97826714653111, 37.56773413818753], zoom: 15.5, pitch: 45,
      });
	//마커찍기
	var marker = new mapboxgl.Marker()
	.setLngLat([126.97826714653111, 37.56773413818753])
	.setPopup(new mapboxgl.Popup().setHTML('<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">우리집</button>'))

	.addTo(map);
	
	//경도 위도 찍기
//	map.on('click', function (e) {
//		console.log(
//		// e.point is the x, y coordinates of the mousemove event relative
//		// to the top-left corner of the map
//		JSON.stringify(e.point) +
//		'<br />' +
//		// e.lngLat is the longitude, latitude geographical position of the event
//		JSON.stringify(e.lngLat.wrap()));
//	});
	  map.on('load', function() {
	        // Insert the layer beneath any symbol layer.
	        var layers = map.getStyle().layers;

	        var labelLayerId;   // 'symbol' type 레이어 ID를 획득한다
	        for (var i = 0; i < layers.length; i++) {
	            if (layers[i].type === 'symbol' && layers[i].layout['text-field']) {
	                labelLayerId = layers[i].id;
	                break;
	            }
	        }

	        // 3차원 건물 레이어를 추가한다.
//	        map.addLayer(
//	            {
//	                'id': '3d-buildings', 'source': 'composite', 'source-layer': 'building',
//	                'filter': ['==', 'extrude', 'true'], 'type': 'fill-extrusion',
//	                'minzoom': 15,
//	                'paint': {
//	                    'fill-extrusion-color': '#aaa',
//
//	                    // zoom 할 때 건물이 부드럽게 표시되도록 보간법(interpolate)을 사용
//	                    'fill-extrusion-height': [
//	                        'interpolate', ['linear'], ['zoom'],
//	                        15, 0, 15.05,
//	                        ['get', 'height']
//	                    ],
//	                    'fill-extrusion-base': [
//	                        'interpolate', ['linear'], ['zoom'],
//	                        15, 0, 15.05,
//	                        ['get', 'min_height']
//	                    ],
//	                    'fill-extrusion-opacity': [
//	                    	'case',
//	                    	['boolean', ['feature-state', 'hover'], false],
//	                    	1,
//	                    	0.5]
//	                }
//	            },
//	            labelLayerId
//	        );
	        map.on('mousemove', '3d-buildings', (e) => {
				if (e.features.length > 0) {
					if (hoveredStateId !== null) {
						map.setFeatureState(
						{ source: 'composite', id: hoveredStateId },
						{ hover: false }
						);
					}
				hoveredStateId = e.features[0].id;
				console.log(hoveredStateId);
				map.setFeatureState(
					{ source: 'states', id: hoveredStateId },
					{ hover: true }
					);
				}
			});
			 
			// When the mouse leaves the state-fill layer, update the feature state of the
			// previously hovered feature.
			map.on('mouseleave', '3d-buildings', () => {
				if (hoveredStateId !== null) {
					map.setFeatureState(
						{ source: 'composite', id: hoveredStateId },
						{ hover: false }
					);
				}
				hoveredStateId = null;
			});
	        
	        map.on('click','3d-buildings',  (e) => {
				new mapboxgl.Popup({ closeOnClick: true })
				.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat])
				.setHTML('<h1>Hello World!</h1>')
				.addTo(map);
				console.log(
						// e.point is the x, y coordinates of the mousemove event relative
						// to the top-left corner of the map
						// e.lngLat is the longitude, latitude geographical position of the event
						JSON.stringify(e.lngLat.wrap()));
						 
			});
	    });
	  
}
