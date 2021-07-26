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
	mapboxgl.accessToken = 'pk.eyJ1IjoibWFjOTk5IiwiYSI6ImNrNzdyOXc5cjBhdWozbG9kajlwNDk3NGwifQ.2Z3kIeNZbwtVaKVl5NldaA';
	var map = new mapboxgl.Map({
	    style: 'mapbox://styles/mapbox/light-v10',
	    center: [126.97826714653111, 37.56773413818753], zoom: 15.5, pitch: 45,
	    bearing: -17.6, container: 'map', antialias: true
	});
	//마커찍기
	var marker = new mapboxgl.Marker()
	.setLngLat([126.97826714653111, 37.56773413818753])
	.addTo(map);
	
	//경도 위도 찍기
	map.on('click', function (e) {
		console.log(
		// e.point is the x, y coordinates of the mousemove event relative
		// to the top-left corner of the map
		JSON.stringify(e.point) +
		'<br />' +
		// e.lngLat is the longitude, latitude geographical position of the event
		JSON.stringify(e.lngLat.wrap()));
		});
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
	        map.addLayer(
	            {
	                'id': '3d-buildings', 'source': 'composite', 'source-layer': 'building',
	                'filter': ['==', 'extrude', 'true'], 'type': 'fill-extrusion',
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
	                    ],
	                    'fill-extrusion-opacity': 0.6
	                }
	            },
	            labelLayerId
	        );
	    });
}
