import { useState } from "react";

function MoneyBar ( {totalMoney, setTotalMoney}) {
    
    const formatMoney = (amount) => {
        return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }

     


    return(
        <>
        <div id='money-bar'>
            ${formatMoney(totalMoney)}
            
        </div>
        
        </>
    )
}

export default MoneyBar;