const p2 = document.querySelector('.p2');

function ubahWarna(){
    p2.style.backgroundColor = 'lightblue';
}

const p3 = document.querySelector('.p3');

function ubahTulisan(){
    const sectionA = document.getElementById('a');
    const h2 = document.createElement('h2');
    const tulis = document.createTextNode('Baru BOII');
    h2.appendChild(tulis);

    sectionA.replaceChild(h2,p3);
    
}

const p4 = document.querySelector('section#b p');
let i = 4;
// membuat li baru 
function list(){
    
    const ul = document.querySelector('section#b ul');
    const li = document.createElement('li');
    const tulisLi = document.createTextNode('item ' + i);
    li.appendChild(tulisLi);
    ul.appendChild(li);
    i++;
}

// membuat li baru menggunakan addEventListener
// p4.addEventListener('click', function(){
//     const ul = document.querySelector('section#b ul');
//     const li = document.createElement('li');
//     const tulisLi = document.createTextNode('item ' + i);
//     li.appendChild(tulisLi);
//     ul.appendChild(li);
//     i++;
// });

p4.addEventListener('mouseenter', function(){
    p4.style.backgroundColor = 'lightblue';
});

p4.addEventListener('mouseleave', function(){
    p4.style.backgroundColor = 'white';
});



p2.onclick = ubahWarna;
p3.onclick = ubahTulisan;
// p4.onclick = list;

