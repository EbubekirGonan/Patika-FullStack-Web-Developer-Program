import React, {useState} from "react";
import ProductCard from "./ProductCard";

function ProductContainer ({products, totalMoney, setTotalMoney}) {

    

    return (
        <>
        <div id='items'>
            
            {products.map((product) => (
              <ProductCard 
              key={product.id} 
              product={product} 
              totalMoney = {totalMoney}
              setTotalMoney={setTotalMoney}
              />
            ))}
          
        </div>

        </>
    )
}

export default ProductContainer;