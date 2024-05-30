import { useState } from "react";

function MoneyBar ( {totalMoney, }) {
    
    const formatMoney = (amount) => {
        return amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      }

    return(
        <>
        <div>
            ${formatMoney(totalMoney)}
            
        </div>
        
        </>
    )
}

export default MoneyBar;