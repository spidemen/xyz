const puppeteer = require('puppeteer');
const path = require('path');
const fs = require('fs').promises;

const retry = (fn, ms, retrycount) => new Promise(resolve => {
    fn()
        .then(resolve)
        .catch((err) => {
            setTimeout(() => {
                if (retrycount <= retryThreshold)
                    retry(fn, ms, retrycount + 1).then(resolve);
                else {
                    return resolve({ _status: statusConectionError, _statusText: err });
                }
            }, ms * 2);
        })
});
const testUrl="https://raw.githubusercontent.com/lad/words/master/words";
(async () => {
    const browser = await puppeteer.launch({ args: ['--no-sandbox', '--disable-setuid-sandbox'], headless: true });;
    var page = await browser.newPage(); 
    // Increase timeout from the default of 30 seconds to 120 seconds, to allow for slow-loading panels
    await page.setDefaultNavigationTimeout(60000);

    const response=await retry(() => page.goto(testUrl, { waitUntil: 'networkidle0' }), 10000, 0);
    if (response['_status'] == 200) {
        let data = await page.evaluate(() => {
            // console.log("account Balance  =" + accountBalance + " receiverExplore length" + receiverAddressExplore);
             console.log( document.querySelector('pre').innerHTML)
            return (
                document.querySelector('pre').innerHTML
            );
        });
        //  console.log(data);
        fs.writeFile('test.txt', data, function(err) {
            if(err) {
                return console.log(err);
            }
            console.log("The file was saved!");
        }); 

    } else{
        console.log("error  Fail to load webpage !");
    }
    await browser.close();
    process.exit()

})();
