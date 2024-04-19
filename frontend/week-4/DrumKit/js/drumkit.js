    function playSound(number){
        switch(number){
            case 1:
                var boom = new Audio('sounds/boom.wav')
                boom.play();
                break;
            case 2:
                var clap = new Audio('sounds/clap.wav')
                clap.play();
                break;
            case 3:
                var hihat = new Audio('sounds/hihat.wav')    
                hihat.play();
                break;
            case 4:
                var kick = new Audio('sounds/kick.wav')  
                kick.play();
                break;
            case 5:
                var openhat = new Audio('sounds/openhat.wav')
                openhat.play();
                break;
            case 6:
                var ride = new Audio('sounds/ride.wav')    
                ride.play();
                break;
            case 7:
                var snare = new Audio('sounds/snare.wav')    
                snare.play();
                break;
            case 8:
                var tink = new Audio('sounds/tink.wav')
                tink.play();
                break;
            case 9:
                var tom = new Audio('sounds/tom.wav')    
                tom.play();
                break;
        }
    
    }

    document.addEventListener('keydown', function(event){
        const pressedKey = event.key.toUpperCase();

        switch(pressedKey){
            case 'A':
                playSound(1);
                break;
            case 'S':
                playSound(2);
                break;
            case 'D':
                playSound(3);
                break;
            case 'F':
                playSound(4);
                break;
            case 'G':
                playSound(5);
                break;
            case 'H':
                playSound(6);
                break;
            case 'J':
                playSound(7);
                break;
            case 'K':
                playSound(8);
                break;
            case 'L':
                playSound(9);
                break;
            
        }
    });


