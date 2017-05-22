function totalSum(from, to) {
  /*
   }
   console.log(from);
   // 작은 따옴표를 더 많이 쓴다...큰따옴표보단...
   console.log(to == 'undefined');
   */
  if (to == undefined) {
    to = from;
    from = 0;
  }
  var sum = 0;
  for (var i = 0; i <= to; i++) {
    sum += i;
  }
  return sum;
}

function handleBtnOk() {
  console.log("OK Button 클릭함.");
}