const newman = require('newman'); 
const fs = require('fs');

newman.run({
    collection: require('./OctocatTest.postman_collection.json'),
    reporters: 'cli'
}).on('beforeRequest', (error, data) => {
    if (error) {
        console.log(error);
        return;
    }
})
.on('request', (error, data) => {
    if (error) {
        console.log(error);
        return;
    }
    const fileName = `response-UserOctocat.txt`;
    const content = data.response.stream.toString();
    
    fs.writeFile(fileName, content, function (error) {
        if (error) { 
             console.error(error); 
        }
     });
});