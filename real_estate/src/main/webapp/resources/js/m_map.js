window.onload = function(){        
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
	
      map.on('click', function (e) {
        var features = map.queryRenderedFeatures(e.point, {
          layers: ['chicago-parks']
        });
     
        if (!features.length) {
          return;
        }
        var feature = features[0];

        var popup = new mapboxgl.Popup({ offset: [0, -15] })
     
          .setLngLat(feature.geometry.coordinates)
          .setHTML(
            '<h3>' +
              feature.properties.title +
              '</h3>' +
              '<p>' +
              feature.properties.description +
              '</p>'
          )
          .addTo(map);
      });
    
}