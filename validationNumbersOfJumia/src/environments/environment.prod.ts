
const machineIPAndPort = 'http://localhost:8081';
// const warName = 'phone-numbers-validation';
const warName = '';
const prefexURL = `${machineIPAndPort}${warName}`;

export const environment = {
  production: true,
  baseUrl: prefexURL,
  customersUrl: prefexURL + '/customers'
};
