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
//        style: 'mapbox://styles/mapbox/streets-v11', //위성 3d
//        style: 'mapbox://styles/2verse/ckshmqk630abm17qmq53aal07', //그냥 3d
//        style: 'mapbox://styles/2verse/ckshha00xiz2517qwoy4omi82', //그냥 3d
        style: 'mapbox://styles/mapbox/streets-v11',
//        style: 'mapbox://styles/2verse/ckslbtctq9uy417pd18hon6f8',
        center:  [
            127.101414,
            37.512579
          ], zoom: 15.5, pitch: 45,
      });
	//마커찍기
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
	 $('#selected_satellite').click(function() {
		 map.setStyle('mapbox://styles/mapbox/satellite-v9');
		 console.log(map.getStyle().layers);
//		 map.addLayer({
//			 id: 'points-of-interest',
//			 source: {
//			 type: 'vector',
//			 url: 'mapbox://mapbox.mapbox-streets-v8'
//			 },
//			 'source-layer': 'poi_label',
//			 type: 'circle',
//			 paint: {
//			 // Mapbox Style Specification paint properties
//			 },
//			 layout: {
//			 // Mapbox Style Specification layout properties
//			 }
//			 });
//		
	 });
	
	 
	 $('#selected_2d').click(function() {
		 map.setStyle('mapbox://styles/mapbox/streets-v11');
		 console.log(map.getStyle().layers);
		 console.log(map.getSource('earthquakes'))
		 	
//	 	setTimeout(testdata,5000);
		 
	 });
	 map.on('styledataloading', (e) => {
//		 if(map.isStyleLoaded())
//			 map.addLayer({
//				    'id': 'state-borders',
//				    'type': 'line',
//				    'source': 'composite',
//				    'source-layer': 'building',
//				    'layout': {},
//				    'paint': {
//				      'line-color': '#627BC1',
//				      'line-width': 2
//				    }
//				  });
//			  
		 });
	 map.on('styledata', (e) => {
		
	 });
	 map.on('idle', () => {
		 console.log( map.loaded());
//			console.log(map.getStyle().layers.length);
//		 console.log(map.isStyleLoaded());
		 if(map.loaded()){
			 console.log(map.getLayer('points-of-interest'));
			 if(undefined==map.getLayer('points-of-interest'))
			 testdata();
		 }
//		 console.log( map.loaded());

	 });
//	 map.on('styledata', (e) => {
//		 console.log(map.isStyleLoaded());
//	 });
	 $('#selected_3d').click(function() {
		 map.setStyle('mapbox://styles/2verse/ckshha00xiz2517qwoy4omi82');
		 console.log(map.getStyle().layers);
//		 map.addLayer({
//			 id: 'points-of-interest',
//			 source: {
//			 type: 'vector',
//			 url: 'mapbox://mapbox.mapbox-streets-v8'
//			 },
//			 'source-layer': 'poi_label',
//			 type: 'circle',
//			 paint: {
//			 // Mapbox Style Specification paint properties
//			 },
//			 layout: {
//			 // Mapbox Style Specification layout properties
//			 }
//			 });
	 });
	  map.on('load', function() {
		  console.log("리셋");
	        // Insert the layer beneath any symbol layer.
//	        var layers = map.getStyle().layers;
//	        var labelLayerId;   // 'symbol' type 레이어 ID를 획득한다
//	        for (var i = 0; i < layers.length; i++) {
//	            if (layers[i].type === 'symbol' && layers[i].layout['text-field']) {
//	                labelLayerId = layers[i].id;
//	                console.log(labelLayerId);
//	                break;
//	            }
//	        }
		  map.addSource('earthquakes', {
			  type: 'geojson',
			  // Use a URL for the value for the `data` property.
			  data: {
				  "features": [
					    {
					      "type": "Feature",
					      "properties": {
					        "title": "Lotte Tower",
					        "height": 33,
					        "type":"building",
					        "extrude" : true,
					        "min-height": 0,
					        "underground":false
					      },
					      "geometry": {
					        "coordinates": [
					          [
					            [
					              127.101804,
					              37.512074
					            ],
					            [
					              127.101914,
					              37.512122
					            ],
					            [
					              127.101995,
					              37.51201
					            ],
					            [
					              127.102158,
					              37.512099
					            ],
					            [
					              127.102086,
					              37.512181
					            ],
					            [
					              127.102293,
					              37.512273
					            ],
					            [
					              127.102277,
					              37.512308
					            ],
					            [
					              127.102327,
					              37.512348
					            ],
					            [
					              127.10223,
					              37.512462
					            ],
					            [
					              127.102158,
					              37.512579
					            ],
					            [
					              127.102136,
					              37.512705
					            ],
					            [
					              127.10218,
					              37.512832
					            ],
					            [
					              127.102258,
					              37.512934
					            ],
					            [
					              127.102124,
					              37.512862
					            ],
					            [
					              127.10265,
					              37.513272
					            ],
					            [
					              127.102533,
					              37.513604
					            ],
					            [
					              127.101691,
					              37.513305
					            ],
					            [
					              127.101503,
					              37.513127
					            ],
					            [
					              127.101461,
					              37.513044
					            ],
					            [
					              127.101513,
					              37.513027
					            ],
					            [
					              127.101456,
					              37.51282
					            ],
					            [
					              127.101362,
					              37.51282
					            ],
					            [
					              127.101414,
					              37.512579
					            ],
					            [
					              127.101634,
					              37.512281
					            ],
					            [
					              127.101804,
					              37.512074
					            ]
					          ]
					        ],
					        "type": "Polygon"
					      },
					      "id": "333333333333333333"
					    }
					  ],
					  "type": "FeatureCollection"
					}
			  });
			   
			  map.addLayer({
				  'id': 'earthquakes-layer',
				  'type': 'line',
				  'source': 'earthquakes',
				  'paint': {
					  'line-color': '#627BC1',
				      'line-width': 2
			  }});
			  map.addLayer({
				  'id': '3d-buildings',
				  'type': 'fill-extrusion',
				  'source': 'earthquakes',
				  'paint': {
					  'fill-extrusion-color':   [
						  "case",
						  [
						    "<=",
						    ["get", "height"],
						    15
						  ],
						  "hsl(0, 98%, 56%)",
						  [
						    "<=",
						    ["get", "height"],
						    30
						  ],
						  "hsl(251, 82%, 57%)",
						  [
						    "<=",
						    ["get", "height"],
						    50
						  ],
						  "hsl(63, 97%, 69%)",
						  [
						    "<=",
						    ["get", "height"],
						    80
						  ],
						  "hsl(30, 100%, 38%)",
						  [
						    "<=",
						    ["get", "height"],
						    130
						  ],
						  "hsl(164, 93%, 37%)",
						  [
						    "<=",
						    ["get", "height"],
						    180
						  ],
						  "hsl(102, 98%, 49%)",
						  [
						    "<=",
						    ["get", "height"],
						    250
						  ],
						  "hsl(224, 100%, 43%)",
						  "hsl(185, 0%, 1%)"
						],
						'fill-extrusion-height' : [
							"interpolate",
							['linear'],
							['zoom'],
							5,
							10,
							15.05,
							["get","height"]]
				  }
			  });
	        console.log(map.getSource('earthquakes'));
//	        map.addLayer({
//	        	'id': '3d-buildings',
//	        	'type': 'fill-extrusion',
//	        	'source': 'composite',
//	        	'source-layer': 'building',
//	        	'filter': ['==', 'extrude', 'true'],
//	        	'paint': {
//	        		'fill-extrusion-color': [
//	        			'case',
//	        			['boolean', ['feature-state', 'hover'], false],
//	        			'#e9e9e9',
//	        			'#ffffff'
//	        			],
//        			'fill-extrusion-height':[
//	        			'case',
//	        			['boolean', ['feature-state', 'hover'], false],
//	        			300,
//	        			0
//	        			], 
//	        			'fill-extrusion-opacity': 0.8
//	        	}
//	        		
//	        	});
//	        map.setFeatureState(
//					{sourceLayer: 'building', source: 'composite', id: '233593617' },
//					{ hover : true }
//					);
//	        map.setFeatureState(
//					{sourceLayer: 'building', source: 'composite', id: '768398467' },
//					{ hover : true }
//					);
		  
		  map.addLayer({
			    'id': 'state-fills',
			    'type': 'fill',
			    'source': 'composite',
			    'source-layer': 'building',
			    'layout': {},
			    'paint': {
			      'fill-color': '#627BC1',
			      'fill-opacity': [
			        'case',
			        ['boolean', ['feature-state', 'hover'], false],
			        1,
			        0.5
			      ]
			    }
			  });
		  
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
//	                    'fill-extrusion-opacity': 0.6
//	                }
//	            },
//	            labelLayerId
//	        );
	        map.on('mousemove', "building-extrusion", (e) => {
//				if (e.features.length > 0) {
//					 map.setFeatureState(
//								{sourceLayer: 'building', source: 'composite', id: e.features[0].id },
//								{ hover : true }
//								);
//				}
			});
			 
			// When the mouse leaves the state-fill layer, update the feature state of the
			// previously hovered feature.
			map.on('mouseleave', '3d-buildings', () => {
//				if (hoveredStateId !== null) {
//					map.setFeatureState(
//						{ source: 'composite', id: hoveredStateId },
//						{ hover: false }
//					);
//				}
//				hoveredStateId = null;
			});
	        
	        map.on('click','3d-buildings',  (e) => {
	        	var test = turf.points([
		            [
			              127.101804,
			              37.512074
			            ],
			            [
			              127.101914,
			              37.512122
			            ],
			            [
			              127.101995,
			              37.51201
			            ],
			            [
			              127.102158,
			              37.512099
			            ],
			            [
			              127.102086,
			              37.512181
			            ],
			            [
			              127.102293,
			              37.512273
			            ],
			            [
			              127.102277,
			              37.512308
			            ],
			            [
			              127.102327,
			              37.512348
			            ],
			            [
			              127.10223,
			              37.512462
			            ],
			            [
			              127.102158,
			              37.512579
			            ],
			            [
			              127.102136,
			              37.512705
			            ],
			            [
			              127.10218,
			              37.512832
			            ],
			            [
			              127.102258,
			              37.512934
			            ],
			            [
			              127.102124,
			              37.512862
			            ],
			            [
			              127.10265,
			              37.513272
			            ],
			            [
			              127.102533,
			              37.513604
			            ],
			            [
			              127.101691,
			              37.513305
			            ],
			            [
			              127.101503,
			              37.513127
			            ],
			            [
			              127.101461,
			              37.513044
			            ],
			            [
			              127.101513,
			              37.513027
			            ],
			            [
			              127.101456,
			              37.51282
			            ],
			            [
			              127.101362,
			              37.51282
			            ],
			            [
			              127.101414,
			              37.512579
			            ],
			            [
			              127.101634,
			              37.512281
			            ],
			            [
			              127.101804,
			              37.512074
			            ]
			          ]);

	        		var center = turf.center(test);
	        		console.log(center);
//	        	console.log(map.getStyle().layers);
	        	//좌표 가져오기!!!!!!!!!!!!!!!!!!!!!!!!!!!
	        	console.log(e.features[0].geometry.coordinates[0]);
	        	console.log(e.features[0]);
				new mapboxgl.Popup({ closeOnClick: true })
//				.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat])
				.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat])
				.addTo(map);
				var marker = new mapboxgl.Marker()
				.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat])
				.setPopup(new mapboxgl.Popup().setHTML('<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">우리집</button>'))

				.addTo(map);
				   map.setFeatureState(
							{sourceLayer: 'building', source: 'composite', id: e.features[0].id },
							{ hover : true }
							);
//				   console.log(map.setFeatureState({sourceLayer: 'building', source: 'composite', id: e.features[0].id }));
//				   console.log(map.getSource('composite'));
//				   console.log(map.getSource('mapbox.mapbox-streets-v8'));
//				   console.log(e.features[0].properties)
//				map.setPaintProperty(
//		        		'building-extrusion',
//		        		'fill-extrusion-opacity',
//		        		0.2
//		        		);
				 popup.setLngLat([e.lngLat.wrap().lng, e.lngLat.wrap().lat]).setHTML(e.features[0].id).addTo(map);
						 
			});
	        
	        const popup = new mapboxgl.Popup({
	        	closeButton: false,
	        	closeOnClick: false
	        	});

	        map.on('mouseenter', '3d-buildings', (e) => {
	        // Change the cursor style as a UI indicator.
	        map.getCanvas().style.cursor = 'pointer';
	     
//	         console.log(e);
	        // Copy coordinates array.
	        const coordinates = e.features[0].geometry.coordinates.slice();
	        const description = e.features[0].properties.description;
	         
	        // Ensure that if the map is zoomed out such that multiple
	        // copies of the feature are visible, the popup appears
	        // over the copy being pointed to.
	        while (Math.abs(e.lngLat.lng - coordinates[0]) > 180) {
	        coordinates[0] += e.lngLat.lng > coordinates[0] ? 360 : -360;
	        
//	        if (e.features.length > 0) {
//	        	map.setFeatureState({
//	        	source: 'composite',
//	        	sourceLayer: 'building',
//	        	id: e.features[0].id,
//	        	}, {
//	        	hover: true
//	        	});
//	        	}
	        }
//	         
	        // Populate the popup and set its coordinates
	        // based on the feature found.
	       
	        });
	        
	    });
	  
}
