<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Create a hover effect</title>
		<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
		<link href="https://api.mapbox.com/mapbox-gl-js/v2.4.0/mapbox-gl.css" rel="stylesheet">
		<script src="https://api.mapbox.com/mapbox-gl-js/v2.4.0/mapbox-gl.js"></script>
		<style>
			body { margin: 0; padding: 0; }
			#map { position: absolute; top: 0; bottom: 0; width: 100%; }
		</style>
	</head>
	<body>
		<div id="map"></div>
	<script>
		mapboxgl.accessToken = 'pk.eyJ1IjoiMnZlcnNlIiwiYSI6ImNrcmRrbTNhbjN0NW0yb3J6cGNkamkwcDAifQ.t8PYasBN9mAiYGvzd9_Ufw';
		const map = new mapboxgl.Map({
			container: 'map',
			style: 'mapbox://styles/mapbox/streets-v11',
			center: [-100.486052, 37.830348],
			zoom: 2
		});
		let hoveredStateId = null;
		 
		map.on('load', () => {
			map.addSource('states', {
				'type': 'geojson',
				'data': 'https://docs.mapbox.com/mapbox-gl-js/assets/us_states.geojson'
			});
			 
			// The feature-state dependent fill-opacity expression will render the hover effect
			// when a feature's hover state is set to true.
			map.addLayer({
				'id': 'state-fills',
				'type': 'fill',
				'source': 'states',
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
			 
			map.addLayer({
				'id': 'state-borders',
				'type': 'line',
				'source': 'states',
				'layout': {},
				'paint': {
					'line-color': '#627BC1',
					'line-width': 2
				}
			});
			 
			// When the user moves their mouse over the state-fill layer, we'll update the
			// feature state for the feature under the mouse.
			map.on('mousemove', 'state-fills', (e) => {
				if (e.features.length > 0) {
					if (hoveredStateId !== null) {
						map.setFeatureState(
							{ source: 'states', id: hoveredStateId },
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
			map.on('mouseleave', 'state-fills', () => {
				if (hoveredStateId !== null) {
					map.setFeatureState(
						{ source: 'states', id: hoveredStateId },
						{ hover: false }
					);
				}
				hoveredStateId = null;
			});
			map.on('click',  (e) => {
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
	</script>
	 
	</body>
</html>