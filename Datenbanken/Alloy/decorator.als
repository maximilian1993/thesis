abstract sig Component {}

sig ConcreteComponent extends Component {}

abstract sig Decorator extends Component {
	component: one Component
}

sig ConcreteDecorator extends Decorator {}

fact noCycles {
	no d: Decorator | d in d.^component
}

fact loneParent {
	all c: Component | lone c.~component
}

pred example {}

run example for 5
