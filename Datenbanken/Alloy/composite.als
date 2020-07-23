abstract sig Component {}

sig Leaf extends Component {}

sig Composite extends Component {
	children: some Component
}

fact noCycles {
	no c: Composite | c in c.^children  // ^ alle Nachkommen
}

fact loneParent {
	all co: Component | lone co.~children  // ~ umgekehrte Richtung (children --> parents)
}

fact oneRoot {
	one co: Component | no co.~children
}

pred example {}

run example for 5
