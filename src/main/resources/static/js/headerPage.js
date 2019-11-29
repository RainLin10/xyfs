// 登录模态框js
const cards = document.querySelectorAll('.card');
/* View Controller                         -----------------------------------------*/
const mBtns = document.querySelectorAll('.js-mBtn');
mBtns.forEach(mBtn => {
    mBtn.addEventListener('click', on_mBtn_click, true);
    mBtn.addEventListener('touch', on_mBtn_click, true);
});

function on_mBtn_click(e) {
    const nextID = e.currentTarget.getAttribute('data-target');
    const next = document.getElementById(nextID);
    if (!next) return;
    bg_change(nextID);
    view_change(next);
    return false;
}

/* Add class to the body */
function bg_change(next) {
    document.body.className = '';
    document.body.classList.add('is-' + next);
}

/* Add class to a card */
function view_change(next) {
    cards.forEach(card => {
        card.classList.remove('is-show');
    });
    next.classList.add('is-show');
}
//end 登录模态框js