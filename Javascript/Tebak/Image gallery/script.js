const container = document.querySelector('.container');
const besar = document.querySelector('.jumbo');
const thumbs = document.querySelectorAll('.thumb');
container.addEventListener('click', function(e){
    
    if (e.target.className == 'thumb') {
        besar.src = e.target.src;

        thumbs.forEach(function(thumb){
            if (thumb.classList.contains('active')) {
                thumb.classList.remove('active');
            }
        });
        e.target.classList.add('active');

    }
    
});
