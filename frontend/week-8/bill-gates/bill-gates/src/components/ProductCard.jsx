import { useState } from "react";

function ProductCard ({product, totalMoney, setTotalMoney}) {

    const [inputValue, setInputValue] = useState(0);
    const [isSellEnabled, setIsSellEnabled] = useState(false)


    const buyItem = () => {
        setInputValue(inputValue + 1);
        setTotalMoney(Number(totalMoney) - Number(product.price))
        setIsSellEnabled(true);
    }

    const sellItem = () => {
        setInputValue(inputValue - 1);
        setTotalMoney(Number(totalMoney) + Number(product.price))
    
        if(inputValue === 1){
            setIsSellEnabled(false);
        }
        
    }


    return (
        <>
            <div key={product.id} className='item'>
                  <img className="item-img" src={product.images[0]}></img>
                  <div className="item-name">{product.title}</div>
                  <div className="item-cost">${product.price}</div>
                  <div className="item-controls">
                    <button className={`item-sell ${isSellEnabled ? 'enabled': ''}`} onClick={sellItem} disabled={inputValue===0}>Sell</button>
                    <input className='item-input' value={inputValue} type="number" pattern='/d*' readOnly name="" id="" />
                    <button className='item-buy' onClick={buyItem}>Buy</button>
                  </div>
            </div>
        </>
    )
}

export default ProductCard;