window.yes = {};
function isInArray(arr, value) {
	for (var i = 0; i < arr.length; i++) {
		if (value === arr[i]) {
			return true;
		}
	}
	return false;
}
/**
 *
 * @param element
 * @type string
 * @param option
 * @type Object
 */
yes.table = function(element, option) {
	let table = document.querySelector(element);
	classList = [ 'table' ];
	let optKeys = Object.keys(option);
	// 判断是否有这个字段并且为true  
	if (isInArray(optKeys, 'border') && option.border) classList.push('table-bordered');
	if (isInArray(optKeys, 'hover') && option.border) classList.push('table-hover');
	if (isInArray(optKeys, 'striped') && option.border) classList.push('table-striped');
	if (isInArray(optKeys, 'condensed') && option.border) classList.push('table-condensed');
	table.className = classList.join(' ');
	let thead = document.createElement('thead');
	let headTr = document.createElement('tr');
	if (typeof option.columns === 'undefined') {
		throw new Error('没有fields字段');
	}
	// 设置表头
	for (let x of option.columns) {
		let td = document.createElement('th');
		td.textContent = x.title;
		headTr.appendChild(td); }
	thead.appendChild(headTr);
	table.appendChild(thead);
	// -------------------------------------------
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let AddData = (dataList) => {
		for (let x of dataList) {
			let dataTr = document.createElement('tr');
			for (let y of option.columns) {
				let td = document.createElement('td');
				td.textContent = x[y.field];
				dataTr.appendChild(td); }
			tbody.appendChild(dataTr); }
	};
	if (typeof option.data !== 'undefined' && option.data !== null) {
		AddData(option.data);
	} else {
		let params = option.params ? option.params : {};
		$.getJSON(option.url, params, (rls) => {
			AddData(rls);
		});
	}
};