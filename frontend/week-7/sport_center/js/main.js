(function () {
    'use strict';

    var header = document.getElementById('header')

    var headerScrolled = function(event) {
        if(window.scrollY > 100) {
            header.classList.add('header-scrolled')
        } else { 
            header.classList.remove('header-scrolled')
        }
    }

    window.addEventListener('load', headerScrolled)
    document.addEventListener('scroll', headerScrolled)
    
    var yogaBtn = document.getElementById("yoga");
    var groupBtn = document.getElementById("group");
    var soloBtn = document.getElementById("solo");
    var stretchingBtn = document.getElementById("stretching")




    var classesTextHead = document.querySelectorAll("#classes .classes-text h3")
    var classesTextParag = document.querySelectorAll("#classes .classes-text p")
    var classesImg = document.getElementById("classes-img")


    yogaBtn.addEventListener('click', (event) => {
        classesImg.src = "./images/yoga.jpg"
        classesTextHead.forEach((head) => {
            head.textContent = "Why are your Yoga?"
        })
        classesTextParag.forEach((parag) => {
            parag.textContent = "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Possimus, nemo reiciendis vero eveniet maxime ratione accusantium temporibus, natus est autem, tenetur praesentium quidem! Quidem, ex ab est exercitationem sapiente reiciendis?"
        })
    });

    groupBtn.addEventListener('click', (event) => {
        // groupBtn.classList.add("classes-buttons-active")
        classesImg.src = "./images/group.webp"
        classesTextHead.forEach((head) => {
            head.textContent = "Why group lessons?"
        })
        classesTextParag.forEach((parag) => {
            parag.textContent = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Repellendus, pariatur."
        })
    });


    soloBtn.addEventListener('click', (event) => {
        classesImg.src = "./images/solo.jpg"
        classesTextHead.forEach((head) => {
            head.textContent = "Why solo lessons?"
        })
        classesTextParag.forEach((parag) => {
            parag.textContent = "Possimus, nemo reiciendis vero eveniet. Lorem ipsum, dolor sit amet consectetur adipisicing elit. "
        })
    });

    stretchingBtn.addEventListener('click', (event) => {
        classesImg.src = "./images/stret.webp"
        classesTextHead.forEach((head) => {
            head.textContent = "What is the stretching?"
        })
        classesTextParag.forEach((parag) => {
            parag.textContent = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maybe nobody knows."
        })
    })


    // CLASSES BUTONLARI

    const btns = document.querySelectorAll('.class-btns')


    btns.forEach( btn  => {
        btn.addEventListener('click', () => {
            btns.forEach(button => {
                button.classList.remove('active');
            });
            btn.classList.add('active')
           
        });
    });



    // btns.addEventListener('click', (event) => {
    //     btns.forEach(button => {
    //         button.classList.remove('active')
    //     })

    //     var activeButton = document.getElementById(event.target.id);
    //     activeButton.classList.add('active');
    // })


    // const buttons = document.querySelectorAll('.btn');
    // buttons.forEach(button => {
    //   button.addEventListener('click', function() {
    //     buttons.forEach(btn => {
    //       btn.classList.remove('selected');
    //     });
    //     this.classList.add('selected');
    //   });
    // });

    // btns.forEach((button) => {
    //     button.addEventListener('click', (event) => {
    //         btns.forEach((btn) => {
    //             btn.classList.remove("active");
    //         })
    
    //         button.classList.add('active');
    //     })
    // })

    var calculateBMI = () => {
        var height = (document.getElementById('height').value)/100;
        var weight = document.getElementById('weight').value;
        var arrow = document.querySelector('#bmi .bmi-img .bmi-clip')
        console.log(arrow);

        let bmi = weight/(height*height);
        console.log(bmi);
        let bmiRatio = ((bmi - 18.5)/22.5)*100;
        

        
        if(bmi > 18.5 && bmi<=40){
            arrow.style.left = bmiRatio + "%";
        }else {
            arrow.style.display = none;
        }  

    }

    var inputHeight = document.querySelector('#height');
    var inputWeight = document.querySelector('#weight');

    inputHeight.addEventListener('change', calculateBMI);
    inputWeight.addEventListener('change', calculateBMI);

    window.addEventListener('load', calculateBMI);


    var burgerMenu = document.querySelector('.burger-menu');
    var navBar = document.querySelector('.navbar-nav');

    burgerMenu.addEventListener('click', () => {
        burgerMenu.classList.toggle("active");
        navBar.classList.toggle("active");
    })
    
    

}) ();